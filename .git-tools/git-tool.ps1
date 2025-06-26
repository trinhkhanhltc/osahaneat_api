
param(
    [string]$Command
)

function Check-UncommittedChanges {
    $status = git status --porcelain
    if ($status) {
        Write-Host "There are uncommitted changes. Continue? (y/n)"
        $answer = Read-Host
        if ($answer -ne "y") { exit 1 }
    }
}

function Check-NeedPull {
    git remote update | Out-Null
    $branch = git rev-parse --abbrev-ref HEAD
    $local = git rev-parse HEAD
    $remote = git rev-parse "origin/$branch"
    $base = git merge-base HEAD "origin/$branch"

    if ($local -eq $remote) {
        return
    } elseif ($local -eq $base) {
        Write-Host "Your branch is behind the remote. Pull before continuing? (y/n)"
        $pullAnswer = Read-Host
        if ($pullAnswer -eq "y") {
            git pull
        }
    }
}

function New-Branch {
    Check-NeedPull
    $type = Read-Host "Enter branch type (feature, bugfix, hotfix, chore)"
    $name = Read-Host "Enter branch name (kebab-case)"
    $branch = "$type/$name"

    $mainExists = git show-ref refs/heads/main 2>$null
    if ($mainExists) {
        git checkout main
    } else {
        git checkout master
    }

    git pull
    git checkout -b $branch
    Write-Host "Branch created: $branch"
}

function Commit-Code {
    $type = Read-Host "Commit type (feat, fix, chore, refactor, docs)"
    $scope = Read-Host "Scope (e.g. auth, api, ui)"
    $message = Read-Host "Short description"
    git add .
    git commit -m "$type($scope): $message"
}

function Push-Code {
    Check-UncommittedChanges
    $branch = git branch --show-current
    git push origin $branch
    Write-Host "Pushed to remote: $branch"
}

function Create-MR {
    if (Get-Command glab -ErrorAction SilentlyContinue) {
        glab mr create --fill
    } elseif (Get-Command gh -ErrorAction SilentlyContinue) {
        gh pr create --fill
    } else {
        Write-Host "Missing glab or gh CLI. Cannot create merge/pull request."
    }
}

switch ($Command) {
    "new-branch" { New-Branch }
    "commit"     { Commit-Code }
    "push"       { Push-Code }
    "mr"         { Create-MR }
    default      { Write-Host "Invalid command. Use: new-branch, commit, push, mr" }
}
