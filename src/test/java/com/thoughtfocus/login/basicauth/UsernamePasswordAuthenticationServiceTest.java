package com.thoughtfocus.login.basicauth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UsernamePasswordAuthenticationServiceTest {

  @InjectMocks
  private UsernamePasswordAuthenticationService usernamePasswordAuthenticationService;

  @Test
  @DisplayName("User registration should fail due to invalid username is null")
  void testUserRegistrationWithUserNull() {
    String username = null;
    String password = "P@ssw0rd";

    boolean result = usernamePasswordAuthenticationService.registerUser(username, password);
    Assertions.assertFalse(result, "User registration should fail due to invalid username is null");
  }

  @Test
  @DisplayName("User registration should fail due to invalid username is empty")
  void testInvalidUsername_emptyusername() {
    String username = "";
    String password = "P@ssw0rd";

    boolean result = usernamePasswordAuthenticationService.registerUser(username, password);

    Assertions.assertFalse(result, "User registration should fail due to invalid username is empty");
  }
  
  @Test
  @DisplayName("User registration should fail due to invalid username (too short)")
  void testInvalidUsername_TooShort() {
    String username = "johny1234";
    String password = "P@ssw0rd";

    boolean result = usernamePasswordAuthenticationService.registerUser(username, password);

    Assertions.assertFalse(result, "User registration should fail due to invalid username (too short)");
  }
  
  @Test
  @DisplayName("User registration should fail due to invalid username (having  special character apart from @ . _)")
  void testInvalidUserName_HavingSpecialCharacter() {
    String username = "john$doe123";
    String password = "Passw0rd";

    boolean result = usernamePasswordAuthenticationService.registerUser(username, password);

    Assertions.assertFalse(result, "User registration should fail due to invalid username (having  special character apart from @ . _)");
  }
  
  @Test
  @DisplayName("User registration should fail due to invalid password is null")
  void testUserRegistrationWithPasswordNull() {
    String username = "johndoe123@gmail.com";
    String password = null;

    boolean result = usernamePasswordAuthenticationService.registerUser(username, password);

    Assertions.assertFalse(result, "User registration should fail due to invalid password is null");
  }
  
  @Test
  @DisplayName("User registration should fail due to invalid password is empty")
  void testInvalidUsername_emptypassword() {
    String username = "john@doe";
    String password = "";

    boolean result = usernamePasswordAuthenticationService.registerUser(username, password);

    Assertions.assertFalse(result, "User registration should fail due to invalid password is empty");
  }

  @Test
  @DisplayName("User registration should fail due to invalid password (too short)")
  void testInvalidPassword_TooShort() {
    String username = "john@doe";
    String password = "pass";

    boolean result = usernamePasswordAuthenticationService.registerUser(username, password);

    Assertions.assertFalse(result, "User registration should fail due to invalid password (too short)");
  }

  @Test
  @DisplayName("User registration should fail due to invalid password (missing uppercase letter)")
  void testInvalidPassword_MissingUppercase() {
    String username = "john@doe";
    String password = "p@ssw0rd1234";

    boolean result = usernamePasswordAuthenticationService.registerUser(username, password);

    Assertions.assertFalse(result, "User registration should fail due to invalid password (missing uppercase letter)");
  }

  @Test
  @DisplayName("User registration should fail due to invalid password (missing lowercase letter)")
  void testInvalidPassword_MissingLowercase() {
    String username = "john@doe";
    String password = "P@SSW0RD1234";

    boolean result = usernamePasswordAuthenticationService.registerUser(username, password);

    Assertions.assertFalse(result, "User registration should fail due to invalid password (missing lowercase letter)");
  }

  @Test
  @DisplayName("User registration should fail due to invalid password (missing digit)")
  void testInvalidPassword_MissingDigit() {
    String username = "john@doe";
    String password = "P@sswordabcd";

    boolean result = usernamePasswordAuthenticationService.registerUser(username, password);

    Assertions.assertFalse(result, "User registration should fail due to invalid password (missing digit)");
  }

  @Test
  @DisplayName("User registration should fail due to invalid password (missing special character)")
  void testInvalidPassword_MissingSpecialCharacter() {
    String username = "john@doe";
    String password = "Passw0rd1234";

    boolean result = usernamePasswordAuthenticationService.registerUser(username, password);

    Assertions.assertFalse(result, "User registration should fail due to invalid password (missing special character)");
  }

  @Test
  @DisplayName("User registration should fail due to same username and password")
  void testInvalidPassword_ContainsUsername() {
    String username = "Johndoe123@gmail.com";
    String password = "Johndoe123@gmail.com";

    boolean result = usernamePasswordAuthenticationService.registerUser(username, password);

    Assertions.assertFalse(result, "User registration should fail due to same username and password");
  }
  
  @Test
  @DisplayName("User registration should succeed")
  void testValiduserRegistration() {
    String username = "naveedmd123@gmail.co.in";
    String password = "P@ssw0rd123";

    boolean result = usernamePasswordAuthenticationService.registerUser(username, password);

    Assertions.assertTrue(result, "User registration should succeed");
  }

  
}
