package com.mvcbasic.MVCApp.controller;


import com.mvcbasic.MVCApp.DTO;
import com.mvcbasic.MVCApp.model.UserDetails;
import com.mvcbasic.MVCApp.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/MVC")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LogManager.getLogger(UserController.class);

    @PostMapping("/save")
    public UserDetails saveUserDetails(@RequestBody UserDetails input){
        logger.info(input.getUserName());
        logger.info(input.getEmailId());
        return userRepository.save(input);
    }

    @GetMapping
    public List<UserDetails> getUserDetails(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserDetails> getUserDetails(@PathVariable Integer id){
        return userRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserDetails(@PathVariable Integer id){
        userRepository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public UserDetails updateUserDetails(@PathVariable Integer id, @RequestBody DTO dto){
        Optional<UserDetails> userDetails = userRepository.findById(id);
        if(userDetails.isPresent()){
            UserDetails user = userDetails.get();
            user.setEmailId(dto.getEmailId());
            logger.info(user.getEmailId());
            return userRepository.save(user);
        }
        else {
            return null;
        }
    }

    @PutMapping("/{id}")
    public UserDetails updateAllUserDetails(@PathVariable Integer id,@RequestBody UserDetails userDetails){
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


    @GetMapping("/param")
    public String getParam(@RequestParam String s){
        return s;
    }

}
