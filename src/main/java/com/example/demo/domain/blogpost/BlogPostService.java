package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class BlogPostService extends AbstractServiceImpl<BlogPost> {

    public BlogPostService(BlogPostRepository repository) {
        super(repository);
    }
}