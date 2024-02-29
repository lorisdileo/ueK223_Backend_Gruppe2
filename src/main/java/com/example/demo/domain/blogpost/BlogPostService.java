package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractServiceImpl;
import com.example.demo.domain.user.UserService;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@Log4j2
public class BlogPostService extends AbstractServiceImpl<BlogPost> {
    UserService userService;
    @Autowired
    public BlogPostService(BlogPostRepository repository, UserService userService) {
        super(repository);
        this.userService = userService;
    }

    @Transactional
    @Override
    public BlogPost updateById(UUID id, BlogPost blogPost) throws NoSuchElementException{
        log.info("Attempting to find blog by id");
        BlogPost toUpdate = repository.findById(id).orElseThrow(NoSuchElementException::new);

        if (!toUpdate.getUser().getId().equals(blogPost.getUser().getId())) {
            log.error("User attempted to change author");
            throw new NoSuchElementException("You are not allowed to update blog posts of other users.");
        }


        log.debug("Attempting to update blogpost with ID '{}'", id);
        if (repository.existsById(id)) {
            blogPost.setId(id);
            blogPost.setUser(toUpdate.getUser());
            log.debug("Updated blogpost with ID '{}'", id);
            return repository.save(blogPost);
        } else {
            log.error("blogpost with ID '{}' was not updated", id);
            throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
        }
    }
}
