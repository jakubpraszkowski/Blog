package com.kubuski.blog.dto;

import java.util.List;
import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDtoV2 {
    @Schema(description = "Post id", example = "1")
    private Long id;

    @Schema(description = "Post title", example = "Spring Boot")
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;

    @Schema(description = "Post description", example = "Spring Boot is a framework")
    @NotEmpty
    @Size(min = 2, message = "Post description should have at least 2 characters")
    private String description;

    @Schema(description = "Post content", example = "Spring Boot is a framework that helps you to build Spring-based applications quickly")
    @NotEmpty
    private String content;

    @Schema(description = "Post author", example = "kubuski")
    private Set<CommentDto> comments;

    @Schema(description = "Post tags", example = "[\"spring\", \"spring-boot\"]")
    private List<String> tags;
}
