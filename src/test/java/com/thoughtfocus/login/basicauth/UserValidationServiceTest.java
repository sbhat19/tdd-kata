package com.thoughtfocus.login.basicauth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserValidationServiceTest {
  
  @InjectMocks
  private UserValidationService userValidationService;
  

  @Test
  @DisplayName("User validation should fail due to invalid username is null")
  void testUserValidationWithUserNull() {
    String username = null;
    boolean result = userValidationService.isValidUsername(username);
    Assertions.assertFalse(result, "User validation should fail due to invalid username is null");
  }
  
  
  @Test
  @DisplayName("User validation should fail due to invalid username is empty")
  void testInvalidUsername_emptyusername() {
    String username = "";
    boolean result = userValidationService.isValidUsername(username);
    Assertions.assertFalse(result, "User validation should fail due to invalid username is null");
  }
  
  @Test
  @DisplayName("User validation should fail due to invalid username is TooShort")
  void testInvalidUsername_TooShort() {
    String username = "johny1234";
    boolean result = userValidationService.isValidUsername(username);
    Assertions.assertFalse(result, "User validation should fail due to invalid username is TooShort");
  }
  
  @Test
  @DisplayName("User validation should fail due to invalid username is (having  special character apart from @ . _)")
  void testInvalidUsername_HavingSpecialCharacter() {
    String username = "johny$1234";
    boolean result = userValidationService.isValidUsername(username);
    Assertions.assertFalse(result, "User validation should fail due to invalid username is TooShort");
  }
  
  @Test
  @DisplayName("User validation should pass")
  void testvalidUsername() {
    String username = "naveedmd123@gmail.co.in";
    boolean result = userValidationService.isValidUsername(username);
    Assertions.assertTrue(result, "User validation should pass");
  }
  
  
}
