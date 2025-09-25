package com.fabioalves.workshopmongo.dto;

import com.fabioalves.workshopmongo.domain.Post;
import com.fabioalves.workshopmongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String id;
    private String name;
    private String email;

    public UserDTO (User obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }
}
