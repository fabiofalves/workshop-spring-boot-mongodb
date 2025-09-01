package com.fabioalves.workshopmongo.services;

import com.fabioalves.workshopmongo.domain.User;
import com.fabioalves.workshopmongo.dto.UserDTO;
import com.fabioalves.workshopmongo.repositories.UserRepository;
import com.fabioalves.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll(){
        return repository.findAll().stream().map(UserDTO::new).toList();
    }

    public UserDTO findById(String id){
        return repository
                .findById(id)
                .map(UserDTO::new)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @Transactional
    public User insert (User obj){
        return repository.insert(obj);
    }

    public User fromDTO (UserDTO objDTO){
        return new User (null, objDTO.getName(), objDTO.getEmail());
    }
}
