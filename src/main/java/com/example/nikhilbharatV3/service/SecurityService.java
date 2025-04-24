package com.example.nikhilbharatV3.service;


import com.example.nikhilbharatV3.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface SecurityService {

	boolean longin(String username, String password, HttpServletRequest request, HttpServletResponse response);
	
	public User save(User user);
}
