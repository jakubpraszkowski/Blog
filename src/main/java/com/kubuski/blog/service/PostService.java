package com.kubuski.blog.service;

import com.kubuski.blog.dto.PostDto;
import com.kubuski.blog.dto.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(Long id);

    PostDto updatePost(Long id, PostDto postDto);

    void deletePostById(Long id);
}
