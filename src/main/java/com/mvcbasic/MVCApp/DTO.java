package com.mvcbasic.MVCApp;

import org.springframework.stereotype.Component;

@Component
public class DTO {
    private String emailId;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
