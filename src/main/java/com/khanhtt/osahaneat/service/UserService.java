package com.khanhtt.osahaneat.service;

import com.khanhtt.osahaneat.dto.UserDTO;
import com.khanhtt.osahaneat.model.LoginRequest;
import com.khanhtt.osahaneat.model.LoginOrSignUpResponse;
import com.khanhtt.osahaneat.model.SignUpRequest;
import java.util.List;

public interface UserService {

  List<UserDTO> getAllUser();

  LoginOrSignUpResponse login(LoginRequest request);
  LoginOrSignUpResponse signup(SignUpRequest request);
}
