package com.mvcbasic.MVCApp.service;

import com.mvcbasic.MVCApp.model.UserDetails;
import com.mvcbasic.MVCApp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testaddValidUser(){

        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("Bala K");
       userDetails.setEmailId("balakannan@gmail.com");
        when(userRepository.save(Mockito.any(UserDetails.class))).thenReturn(userDetails);

        UserDetails userDetails1 = userService.addUserDetails(userDetails);
        assertNotNull(userDetails1);
        assertEquals("Bala K",userDetails1.getUserName());
        assertEquals("balakannan@gmail.com",userDetails1.getEmailId());
    }

    @Test
    void userNameIsBlank(){
        UserDetails userDetails = new UserDetails("","balakannan@gmail.com");
        assertThrows(IllegalArgumentException.class,()->{
            userService.addUserDetails(userDetails);
        });
    }

    @Test
    void userEmailIsBlank(){
        UserDetails userDetails = new UserDetails("Bala K","");
        assertThrows(IllegalArgumentException.class,()->{
            userService.addUserDetails(userDetails);
        });
    }

    @Test
    void NotvalidName(){
        UserDetails userDetails = new UserDetails("Bala_K","balakannantvl@gmail.com");
        assertThrows(IllegalArgumentException.class,()->{
            userService.addUserDetails(userDetails);
        });
    }


    @Test
    void NotvalidEmail(){
        UserDetails userDetails = new UserDetails("Bala K","@ohnDoe@gmail.com");
        //UserDetails userDetails = new UserDetails("Bala_K","balakannantvl@gmail.com");
        assertThrows(IllegalArgumentException.class,()->{
            userService.addUserDetails(userDetails);
        });
    }

    @Test
    void ValidValueForGetDetailsById(){
        assertThrows(IllegalArgumentException.class,()->{
            userService.getUserById(-4);
        });
    }


}