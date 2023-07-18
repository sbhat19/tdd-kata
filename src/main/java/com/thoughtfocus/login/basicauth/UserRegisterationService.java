package com.thoughtfocus.login.basicauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterationService {
  
  @Autowired
  private UserValidationService userValidationService;
  
  public Boolean registerUser(String userName, String password) {
    return userValidationService.isValidUsername(userName) && userValidationService.isValidPassword(userName, password);
  }

}
