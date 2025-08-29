package com.fabioalves.workshopmongo.services;

import com.fabioalves.workshopmongo.domain.User;
import com.fabioalves.workshopmongo.dto.UserDTO;
import com.fabioalves.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll(){
        return repository.findAll().stream().map(UserDTO::new).toList();
    }
}
