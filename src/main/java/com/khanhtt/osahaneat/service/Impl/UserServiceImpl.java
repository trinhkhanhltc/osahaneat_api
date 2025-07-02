package com.khanhtt.osahaneat.service.Impl;

import com.khanhtt.osahaneat.dto.UserDTO;
import com.khanhtt.osahaneat.entity.Roles;
import com.khanhtt.osahaneat.entity.Users;
import com.khanhtt.osahaneat.model.LoginOrSignUpResponse;
import com.khanhtt.osahaneat.model.LoginRequest;
import com.khanhtt.osahaneat.model.SignUpRequest;
import com.khanhtt.osahaneat.repository.UserRepository;
import com.khanhtt.osahaneat.service.UserService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository repository;

  public List<UserDTO> getAllUser() {
    List<Users> users = repository.findAll();
    List<UserDTO> userDTOList = new ArrayList<>();
    for (Users user : users) {
      UserDTO userDTO = new UserDTO();
      userDTO.setUserName(user.getUserName());
      userDTO.setFullname(user.getFullName());
      userDTO.setPassword(user.getPassword());
      userDTO.setCreateDate(user.getCreateDate());
      userDTOList.add(userDTO);
    }
    return userDTOList;
  }

  @Override
  public LoginOrSignUpResponse login(LoginRequest request) {
    List<Users> userList = repository.findByUserNameAndPassword(request.getUsername(),
        request.getPassword());
    if (!userList.isEmpty()) {
      return new LoginOrSignUpResponse(true, "Login successful");
    } else {
      return new LoginOrSignUpResponse(false, "Invalid username or password");
    }
  }

  @Override
  public LoginOrSignUpResponse signup(SignUpRequest request) {
    if (repository.existsByUserName(request.getUserName()))
      return new LoginOrSignUpResponse(false, "username already exists!");
    Roles roles = new Roles();
    roles.setId(request.getRoleId());
    Users users = new Users();
    users.setFullName(request.getFullName());
    users.setUserName(request.getUserName());
    users.setPassword(request.getPassword());
    users.setRoles(roles);
    try {
      repository.save(users);
      return new LoginOrSignUpResponse(true, "Sign up successful!");
    } catch (Exception e) {
      return new LoginOrSignUpResponse(false, "Sign up failed!");
    }
  }

}
