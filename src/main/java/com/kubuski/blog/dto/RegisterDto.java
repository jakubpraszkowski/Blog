package com.kubuski.blog.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    @Schema(description = "User id", example = "1")
    private String name;

    @Schema(description = "User username", example = "kubuski")
    private String username;

    @Schema(description = "User email", example = "kubuski@mail.com")
    private String email;

    @Schema(description = "User password", example = "password")
    private String password;
}
