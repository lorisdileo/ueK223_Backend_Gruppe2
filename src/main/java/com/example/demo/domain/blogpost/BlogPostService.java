package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractRepository;
import com.example.demo.core.generic.AbstractServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class BlogPostService extends AbstractServiceImpl<BlogPost> {

    public BlogPostService(BlogPostRepository repository) {
        super(repository);
    }
}