package com.thoughtfocus.login.service;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class RememberAuthenticateService {

	private static final String REMEMBER_ME_COOKIE_NAME = "rememberMeToken";

	public Boolean checkCookieExistsOrNot(HttpServletRequest request) {

		Cookie[] cookieList = request.getCookies();
		if (ObjectUtils.isEmpty(cookieList)) {
			return false;
		}
		for (Cookie c : cookieList) {
			if (c.getName().equals(REMEMBER_ME_COOKIE_NAME)) {
				return true;
			}
		}
		return false;
	}

 

}
