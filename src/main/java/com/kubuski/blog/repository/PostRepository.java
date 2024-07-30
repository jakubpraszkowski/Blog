package com.kubuski.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kubuski.blog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
