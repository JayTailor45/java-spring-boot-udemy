package com.jt.spring_udemy.repositories;

import com.jt.spring_udemy.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
