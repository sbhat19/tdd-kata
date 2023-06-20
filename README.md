# Login Kata
 
 Login  
- 
- User name and password authentication

	- User name	
		- should not be empty
		- should be an email
		- minimum length should be 10 character
		- Should allow these character ._ @ 
		- User name and password should not be same.
		
	- Password
		- minimum length 10 characters
		- Should contain atleast 1 Number
		- Should contain atleast 1 alphabet
		- Should contain atleast 1 uppercase
		- Should contain atleast 1 special character
		- User name and password should not be same.
		
- Remember Me authentication

	- Browser cookie based validation
		- Cookie should not be empty.
		- Cookie expiration should be set. 
		- Cookie name should be unique.
		- Cookie character should be of 30 character.
		- Succesful authentication if cookie matches with server side cookie.
	    - Failure authentication if cookie doesnt matches with server side cookie.
		
	
- SSO based authentication

   - Active directory based validation.
	 - Account should be registered in the Active directory.
	 - User should be authenticated against the Active directory.

	
- MFA based authentication (email based)
	 - User should validate against user name and password.
	 - On successful validation OTP will be sent to the registered email id.
	 - User should authenticated against the valid OTP i.e received on the email id.

