package com.fabioalves.workshopmongo.services;

import com.fabioalves.workshopmongo.domain.User;
import com.fabioalves.workshopmongo.dto.UserDTO;
import com.fabioalves.workshopmongo.repositories.UserRepository;
import com.fabioalves.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @Transactional
    public User insert (User obj){
        return repository.insert(obj);
    }

    @Transactional
    public void deleteById (@PathVariable String id){
        findById(id);
        repository.deleteById(id);
    }

    @Transactional
    public User update (User obj){
        User newObj = repository.findById(obj.getId()).get();
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO (UserDTO objDTO){
        return new User (objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
