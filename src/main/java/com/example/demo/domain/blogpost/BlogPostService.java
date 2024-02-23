package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractServiceImpl;
import com.example.demo.domain.user.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Log4j2
public class BlogPostService extends AbstractServiceImpl<BlogPost> {
    private final UserService userservice;

    @Autowired
    public BlogPostService(BlogPostRepository repository, UserService userservice) {
        super(repository);
        this.userservice = userservice;
    }

    @Override
    public BlogPost save(BlogPost blogPost){
        if (userservice.existsById(blogPost.getUser().getId())) {
            blogPost.setUser(userservice.findById(blogPost.getUser().getId()));
            return repository.save(blogPost);
        }
        else {
            throw new NoSuchElementException(String.format("User with ID '%s' could not be found", blogPost.getUser().getId()));
        }
    }

}