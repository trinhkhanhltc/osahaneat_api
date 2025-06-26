#!/bin/bash

function check_uncommitted_changes() {
  if [[ -n $(git status --porcelain) ]]; then
    echo "⚠️  Có thay đổi chưa commit. Bạn có chắc muốn tiếp tục? (y/n)"
    read -r answer
    if [[ $answer != "y" ]]; then
      exit 1
    fi
  fi
}

function check_need_pull() {
  git remote update > /dev/null 2>&1
  LOCAL=$(git rev-parse @)
  REMOTE=$(git rev-parse @{u})
  BASE=$(git merge-base @ @{u})

  if [ $LOCAL = $REMOTE ]; then
    return
  elif [ $LOCAL = $BASE ]; then
    echo "⚠️  Nhánh của bạn đang cũ hơn so với remote. Nên pull trước khi tiếp tục."
    echo "Bạn có muốn pull không? (y/n)"
    read -r pullanswer
    if [[ $pullanswer == "y" ]]; then
      git pull
    fi
  fi
}

function new_branch() {
  check_need_pull
  echo "Nhập loại nhánh (feature, bugfix, hotfix, chore):"
  read -r type
  echo "Nhập tên nhánh (viết-kebab-case):"
  read -r name
  branch="$type/$name"
  git checkout main || git checkout master
  git pull
  git checkout -b "$branch"
  echo "✔️ Đã tạo nhánh: $branch"
}

function commit_code() {
  echo "Loại commit (feat, fix, chore, refactor, docs):"
  read -r type
  echo "Scope (ví dụ: auth, api, ui):"
  read -r scope
  echo "Mô tả ngắn:"
  read -r message
  git add .
  git commit -m "$type($scope): $message"
}

function push_code() {
  check_uncommitted_changes
  branch=$(git branch --show-current)
  git push origin "$branch"
  echo "✔️ Đã push lên remote: $branch"
}

function create_mr() {
  if command -v glab &> /dev/null; then
    glab mr create --fill
  elif command -v gh &> /dev/null; then
    gh pr create --fill
  else
    echo "❌ Không tìm thấy glab hoặc gh để tạo merge request/pull request."
  fi
}

case "$1" in
  new-branch) new_branch ;;
  commit) commit_code ;;
  push) push_code ;;
  mr) create_mr ;;
  *) echo "❌ Lệnh không hợp lệ. Dùng: new-branch, commit, push, mr" ;;
esac
