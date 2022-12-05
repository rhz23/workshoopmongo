package com.rzaninelli.workshoopmongo.services;

import com.rzaninelli.workshoopmongo.domain.User;
import com.rzaninelli.workshoopmongo.repository.UserRepository;
import com.rzaninelli.workshoopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){

        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }
}
