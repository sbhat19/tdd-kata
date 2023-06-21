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
	    request.setCookies(new Cookie("userName","123456"));
		Boolean actual = rememberAuthenticateService.checkCookieExistsOrNot(request);
		assertEquals(Boolean.FALSE, actual);
	}
	
	
	@Test
	@DisplayName("Check whether cookie property exists and return true")
	void checkCookiePropertyExist() {
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    Cookie cookie = new Cookie("rememberMeToken","123456");
	    cookie.setMaxAge(1000);
	    request.setCookies(cookie);
		Boolean actual = rememberAuthenticateService.checkCookieExistsOrNot(request);
		assertEquals(Boolean.TRUE, actual);
	}
	
	@Test
	@DisplayName("Should fail when the expiry is -1")
	void checkWhetherCookieExpiryIsSet() {
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setCookies(new Cookie("rememberMeToken","123456"));
		Boolean actual = rememberAuthenticateService.checkCookieExistsOrNot(request);
		assertEquals(Boolean.FALSE, actual);
	}
	
	
	@Test
	@DisplayName("Should pass for the valid cookie from the client")
	void cookieValueShouldMatchWithServerCookieAndLogin() {
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    Cookie cookie = new Cookie("rememberMeToken","123456");
	    cookie.setMaxAge(1000);
	    request.setCookies(cookie);
	    Boolean actual = rememberAuthenticateService.checkCookieExistsOrNot(request);
		assertEquals(Boolean.TRUE, actual);
	}
	
	@Test
	@DisplayName("Should fail for the invalid cookie from the client")
	void cookieValueShouldNotMatchWithServerCookie() {
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    Cookie cookie = new Cookie("rememberMeToken","654321");
	    cookie.setMaxAge(1000);
	    request.setCookies(cookie);
	    Boolean actual = rememberAuthenticateService.checkCookieExistsOrNot(request);
		assertEquals(Boolean.FALSE, actual);
	}

}
