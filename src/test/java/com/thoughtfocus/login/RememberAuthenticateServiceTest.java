package com.thoughtfocus.login;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;

import com.thoughtfocus.login.service.RememberAuthenticateService;

import jakarta.servlet.http.Cookie;

@ExtendWith(MockitoExtension.class)
class RememberAuthenticateServiceTest {
	
@InjectMocks
RememberAuthenticateService rememberAuthenticateService;

	@Test
	@DisplayName("Check whether cookie is empty or not")
	void checkCookieExistsOrNot() {
	    MockHttpServletRequest request = new MockHttpServletRequest();
		Boolean actual = rememberAuthenticateService.checkCookieExistsOrNot(request);
		assertEquals(Boolean.FALSE, actual);
	}
	
	@Test
	@DisplayName("Check whether cookie property exists or not and return false")
	void checkCookiePropertyExistsOrNot() {
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setCookies(new Cookie("userName","test@gamil.com"));
		Boolean actual = rememberAuthenticateService.checkCookieExistsOrNot(request);
		assertEquals(Boolean.FALSE, actual);
	}
	
	
	@Test
	@DisplayName("Check whether cookie property exists and return true")
	void checkCookiePropertyExist() {
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setCookies(new Cookie("rememberMeToken","test@gamil.com"));
		Boolean actual = rememberAuthenticateService.checkCookieExistsOrNot(request);
		assertEquals(Boolean.TRUE, actual);
	}

}
