package com.blog.security.RoleBasedBlog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.security.RoleBasedBlog.entity.Blog;
import com.blog.security.RoleBasedBlog.service.BlogService;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<Blog> getAll() {
        return blogService.getAllBlogs();
    }

    @GetMapping("{id}")
    public Optional<Blog> getById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // only admin can add blog
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.addBlog(blog);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')") // only admin can update blog
    public Blog updateBlog(@PathVariable long id, @RequestBody Blog blogdetials) {
        return blogService.updateBlogDetails(id, blogdetials);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return "Blog deleted successfully";
    }

    // Search blogs
    @GetMapping("/search")
    public List<Blog> searchBlogs(@RequestParam String keyword) {
        return blogService.searchBlogs(keyword);
    }
}
