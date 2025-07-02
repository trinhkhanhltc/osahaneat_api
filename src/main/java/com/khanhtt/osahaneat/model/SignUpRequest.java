package com.khanhtt.osahaneat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
  private String fullName;
  private String userName;
  private String password;
  private int roleId;

}
