package com.khanhtt.osahaneat.controller;

import com.khanhtt.osahaneat.dto.UserDTO;
import com.khanhtt.osahaneat.model.LoginRequest;
import com.khanhtt.osahaneat.model.LoginOrSignUpResponse;
import com.khanhtt.osahaneat.model.SignUpRequest;
import com.khanhtt.osahaneat.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {

  private final UserService service;

  @GetMapping()
  public List<UserDTO> getAll() {
    return service.getAllUser();
  }

  @PostMapping("/login")
  public LoginOrSignUpResponse login(@RequestBody LoginRequest request)
  {
    return service.login(request);
  }

  @PostMapping("signup")
  public LoginOrSignUpResponse signup(@RequestBody SignUpRequest request)
  {
    return service.signup(request);
  }
}
