package com.fabioalves.workshopmongo.services;

import com.fabioalves.workshopmongo.domain.Post;
import com.fabioalves.workshopmongo.repositories.PostRepository;
import com.fabioalves.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text){
        return repository.searchTitle(text);
    }
}
