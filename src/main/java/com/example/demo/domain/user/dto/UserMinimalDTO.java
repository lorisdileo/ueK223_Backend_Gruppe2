package com.example.demo.domain.user.dto;

import com.example.demo.core.generic.AbstractDTO;
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
public class UserMinimalDTO extends AbstractDTO {
    public UserMinimalDTO(UUID id){
        super(id);
    }

    @Size(min=1, max=100, message = "has to be between 1 and 100 characters")
    private String firstName;

    @Size(min=1, max=100, message = "has to be between 1 and 100 characters")
    private String lastName;
}