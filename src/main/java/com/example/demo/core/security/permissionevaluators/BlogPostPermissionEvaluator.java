package com.example.demo.core.security.permissionevaluators;

import com.example.demo.domain.blogpost.BlogPost;
import com.example.demo.domain.blogpost.BlogPostService;
import com.example.demo.domain.role.Role;
import com.example.demo.domain.user.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Log4j2
public class BlogPostPermissionEvaluator {
    @Autowired
    private BlogPostService service;

    public boolean isPostForUser(User user, String blogPostId) {
        // If user is Admin, is automatically granted
        if (user.getRoles().stream().anyMatch(r -> r.getName().equals("ADMIN"))) {
            return true;
        } else {
            BlogPost post = service.findById(UUID.fromString(blogPostId));
            return post.getUser().getId().equals(user.getId());
        }
    }
}