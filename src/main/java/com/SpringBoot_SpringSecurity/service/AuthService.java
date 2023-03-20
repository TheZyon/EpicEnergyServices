package com.SpringBoot_SpringSecurity.service;

import com.SpringBoot_SpringSecurity.payload.LoginDto;
import com.SpringBoot_SpringSecurity.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
