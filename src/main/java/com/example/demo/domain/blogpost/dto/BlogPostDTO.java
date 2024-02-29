package com.example.demo.domain.blogpost.dto;

import com.example.demo.core.generic.AbstractDTO;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.dto.UserDTO;
import com.example.demo.domain.user.dto.UserMinimalDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;
/*
 * basic DTO, mainly used in frontend
 */
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class BlogPostDTO extends AbstractDTO {

    @NotNull
    @Size(min=1, max=500, message = "has to be between 1 and 500 characters")
    private String title;

    @NotNull
    @Size(min=1, max=500, message = "has to be between 1 and 500 characters")
    private String text;

    @NotNull
    @Size(min=1, max=100, message = "has to be between 1 and 100 characters")
    private String category;

    @NotNull
    private UserMinimalDTO user;

    public BlogPostDTO(UUID id, String title, String text, String category, UserMinimalDTO user){
        super(id);
        this.title = title;
        this.text = text;
        this.category = category;
        this.user = user;
    }
}