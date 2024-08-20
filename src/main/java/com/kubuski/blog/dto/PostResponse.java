package com.kubuski.blog.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    @Schema(description = "List of posts", example = "[{\"id\":1,\"title\":\"Spring Boot\",\"description\":\"Spring Boot is a framework\",\"content\":\"Spring Boot is a framework that helps you to build Spring-based applications quickly\",\"comments\":[{\"id\":1,\"content\":\"Great post!\"}],\"categoryId\":1}]")
    private List<PostDto> content;

    @Schema(description = "Page number", example = "0")
    private int pageNo;

    @Schema(description = "Page size", example = "10")
    private int pageSize;

    @Schema(description = "Total number of elements", example = "1")
    private Long totalElements;

    @Schema(description = "Total number of pages", example = "1")
    private int totalPages;

    @Schema(description = "Is last page", example = "true")
    private boolean last;
}
