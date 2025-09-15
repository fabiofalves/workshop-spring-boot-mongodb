package com.fabioalves.workshopmongo.dto;

import com.fabioalves.workshopmongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDTO {

    private String id;
    private String name;

    public AuthorDTO (User obj){
        id = obj.getId();
        name = obj.getName();
    }
}
