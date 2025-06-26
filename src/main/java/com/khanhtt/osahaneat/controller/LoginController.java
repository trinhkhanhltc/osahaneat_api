package com.khanhtt.osahaneat.controller;

import com.khanhtt.osahaneat.dto.UserDTO;
import com.khanhtt.osahaneat.entity.Users;
import com.khanhtt.osahaneat.repository.UserRepository;
import com.khanhtt.osahaneat.service.UserService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
  private final UserService service;
  @GetMapping()
  public List<UserDTO> getAll() {
    return service.getAllUser();
  }
}
