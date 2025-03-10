package com.mvcbasic.MVCApp.controller;
import com.mvcbasic.MVCApp.DTO;
import com.mvcbasic.MVCApp.model.UserDetails;
import com.mvcbasic.MVCApp.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/MVC")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LogManager.getLogger(UserController.class);

    @PostMapping("/save")
    public UserDetails saveUserDetails(@RequestBody UserDetails input){
        return userService.addUserDetails(input);
    }

    @GetMapping
    public List<UserDetails> getUserDetails(){
       return userService.getAllUserDetails();
    }

    @GetMapping("/{id}")
    public UserDetails getUserDetails(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserDetails(@PathVariable Integer id){
       userService.deleteUserById(id);
    }

    @PatchMapping("/{id}")
    public UserDetails updateUserDetails(@PathVariable Integer id, @RequestBody DTO dto){
        return userService.updateUserEmail(id,dto);
    }

    @PutMapping("/{id}")
    public UserDetails updateAllUserDetails(@PathVariable Integer id, @RequestBody UserDetails userDetails){
        return userService.updateAllUserDetailsById(id,userDetails);
    }
}
