package com.blog.security.RoleBasedBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.security.RoleBasedBlog.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    // Custom search method to find blogs by title, description, or related content
    List<Blog> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrRelatedContainingIgnoreCase(
            String title, String description, String related);
}
