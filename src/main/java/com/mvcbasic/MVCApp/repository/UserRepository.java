package com.mvcbasic.MVCApp.repository;

import com.mvcbasic.MVCApp.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails,Integer> {
    
}
