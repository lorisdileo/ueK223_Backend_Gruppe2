package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractEntity;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.dto.UserDTO;
import com.example.demo.domain.user.dto.UserMinimalDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blogpost")
public class BlogPost extends AbstractEntity {


    @Column(name="title")
    @NotNull
    @Size(min=1, max=500, message = "has to be between 1 and 500 characters")
    private String title;

    @Column(name="text")
    @NotNull
    @Size(min=1, max=500, message = "has to be between 1 and 500 characters")
    private String text;

    @Column(name="category")
    @NotNull
    @Size(min=1, max=100, message = "has to be between 1 and 100 characters")
    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
