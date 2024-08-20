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
public class CategoryDto {
    @Schema(description = "Category id", example = "1")
    private Long id;

    @Schema(description = "Category name", example = "Spring Boot")
    private String name;

    @Schema(description = "Category description", example = "Spring Boot is a framework")
    private String description;
}
