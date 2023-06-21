package com.thoughtfocus.login.basicauth;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class UsernamePasswordAuthenticationService {
  
  public Boolean registerUser(String userName, String password) {
    return isValidUsername(userName) && isValidPassword(userName, password);
  }

  private Boolean isValidUsername(String userName)
  {
    String emailPattern = "^[a-zA-Z0-9_.]+@[a-zA-Z0-9.-]+$";
    return StringUtils.isNotBlank(userName) && userName.length() >= 10 && userName.matches(emailPattern);
  }
  
  private boolean isValidPassword(String userName, String password) {
    return StringUtils.isNotBlank(password) && password.length() >= 10 && password.matches(".*[A-Z].*") &&
        password.matches(".*[a-z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()].*") &&
        !password.equalsIgnoreCase(userName);
  }

}
