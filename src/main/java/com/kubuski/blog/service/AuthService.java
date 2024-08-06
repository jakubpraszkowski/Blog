package com.kubuski.blog.service;

import com.kubuski.blog.dto.LoginDto;
import com.kubuski.blog.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
