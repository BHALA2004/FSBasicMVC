package com.mvcbasic.MVCApp.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "USER_DETAILS")
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int userId;

    @Column(name = "USERNAME")
    public String userName;

    @Column(name = "EMAIL")
    public String emailId;

    public UserDetails(String userName, String emailId) {
        this.userName = userName;
        this.emailId = emailId;
    }

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
