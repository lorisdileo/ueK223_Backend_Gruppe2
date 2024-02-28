package com.example.demo.domain.blogpost.dto;


import com.example.demo.core.generic.AbstractDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CreateBlogPostDTO extends AbstractDTO {

    @NotNull
    @Size(min=1, max=500, message = "has to be between 1 and 500 characters")
    private String title;

    @NotNull
    @Size(min=1, max=500, message = "has to be between 1 and 500 characters")
    private String text;

    @NotNull
    @Size(min=1, max=100, message = "has to be between 1 and 100 characters")
    private String category;

    public CreateBlogPostDTO(UUID id, String title, String text, String category){
        super(id);
        this.title = title;
        this.text = text;
        this.category = category;
    }
}