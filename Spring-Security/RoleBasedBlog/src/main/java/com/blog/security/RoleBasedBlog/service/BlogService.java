package com.blog.security.RoleBasedBlog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.security.RoleBasedBlog.entity.Blog;
import com.blog.security.RoleBasedBlog.repository.BlogRepository;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public Blog addBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog updateBlogDetails(Long id, Blog blogDetails) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
        blog.setTitle(blogDetails.getTitle());
        blog.setDescription(blogDetails.getDescription());
        blog.setRelated(blogDetails.getRelated());
        return blogRepository.save(blog);
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    public List<Blog> searchBlogs(String keyword) {
        return blogRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrRelatedContainingIgnoreCase(keyword, keyword, keyword);
    }
}
