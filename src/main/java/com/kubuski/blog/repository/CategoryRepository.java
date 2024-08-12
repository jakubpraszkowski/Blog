package com.kubuski.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kubuski.blog.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
