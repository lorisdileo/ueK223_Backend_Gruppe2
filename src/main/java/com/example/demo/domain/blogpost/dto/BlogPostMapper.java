package com.example.demo.domain.blogpost.dto;
import com.example.demo.core.generic.AbstractMapper;
import com.example.demo.domain.blogpost.BlogPost;
import com.example.demo.domain.user.dto.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN, uses = UserMapper.class)
public interface BlogPostMapper extends AbstractMapper<BlogPost, BlogPostDTO> {

}