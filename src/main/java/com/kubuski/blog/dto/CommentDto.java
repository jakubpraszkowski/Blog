package com.kubuski.blog.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {
    @Schema(description = "Comment id", example = "1")
    private Long id;

    @NotEmpty(message = "Name is required")
    @Schema(description = "Comment author", example = "kubuski")
    private String name;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email is invalid")
    @Schema(description = "Comment author email", example = "1")
    private String email;

    @NotEmpty(message = "Body is required")
    @Size(min = 10, message = "Body must be at least 10 characters long")
    @Schema(description = "Comment body", example = "This is a comment")
    private String body;
}
