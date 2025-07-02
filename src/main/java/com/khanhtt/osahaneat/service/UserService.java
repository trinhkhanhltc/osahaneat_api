package com.khanhtt.osahaneat.service;

import com.khanhtt.osahaneat.dto.UserDTO;
import com.khanhtt.osahaneat.model.LoginRequest;
import com.khanhtt.osahaneat.model.LoginResponse;
import java.util.List;

public interface UserService {

  List<UserDTO> getAllUser();

  LoginResponse login(LoginRequest request);
}
