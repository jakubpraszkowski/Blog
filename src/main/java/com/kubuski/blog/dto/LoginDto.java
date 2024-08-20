package com.kubuski.blog.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    @Schema(description = "Username or email", example = "admin")
    private String usernameOrEmail;

    @Schema(description = "Password", example = "admin")
    private String password;
}
