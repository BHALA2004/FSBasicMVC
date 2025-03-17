package com.mvcbasic.MVCApp.service;


import com.mvcbasic.MVCApp.DTO;
import com.mvcbasic.MVCApp.model.UserDetails;
import com.mvcbasic.MVCApp.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DTO dto;


    public UserDetails addUserDetails(UserDetails userDetails){

        if(userDetails.getUserName().isBlank() || !(userDetails.getUserName().matches("^[A-Z][a-z]+( | [A-Z]|[A-Z][a-z]+)*"))){
            throw new IllegalArgumentException("Username cannot be empty or Invalid Format");
        }
        if(userDetails.getEmailId().isBlank() || !userDetails.getEmailId().matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")){
            throw new IllegalArgumentException("User Email not Valid or Empty");
        }
        return userRepository.save(userDetails);
    }

    public List<UserDetails> getAllUserDetails(){
        return userRepository.findAll();
    }

    public UserDetails getUserById(int id){
        if(id<=0){
            throw new IllegalArgumentException("Wrong Input");
        }
        Optional<UserDetails> userDetails = userRepository.findById(id);
        return userDetails.get();
    }


    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }

    public UserDetails updateUserEmail(int id, DTO dto){
        Optional<UserDetails> userDetails = userRepository.findById(id);
        if(userDetails.isPresent()){
            UserDetails user = userDetails.get();
            user.setEmailId(dto.getEmailId());
            return userRepository.save(user);
        }
        else {
            return null;
        }
    }

    public UserDetails updateAllUserDetailsById(int id,UserDetails userDetails){
        Optional<UserDetails> userDetailsNew = userRepository.findById(id);
        if(userDetailsNew.isPresent()){
            UserDetails user = userDetailsNew.get();
            user.setUserName(userDetails.getUserName());
            user.setEmailId(userDetails.getEmailId());
            return userRepository.save(user);
        }
        else {
            return null;
        }
    }

    @Value("${app.name}")
    private String name;

    @Value("${app.version}")
    private String version;


    @PostConstruct
    public void print(){
        System.out.println(name+" "+version);
    }




}
