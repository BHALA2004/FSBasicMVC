package com.mvcbasic.MVCApp.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int userId;

    @Column(name = "USERNAME")
    public String userName;

    @Column(name = "EMAIL")
    public String emailId;

    public String getUserName()
    {
        return this.userName;
    }

    public String getEmailId(){return this.emailId;}

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
