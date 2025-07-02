package com.khanhtt.osahaneat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginOrSignUpResponse {
  private boolean success;
  private String messenger;
}
