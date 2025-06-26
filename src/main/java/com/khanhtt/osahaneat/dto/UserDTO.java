package com.khanhtt.osahaneat.dto;

import java.util.Date;
import lombok.Data;

@Data
public class UserDTO {
  private String userName;
  private String password;
  private String fullname;
  private Date createDate;

}
