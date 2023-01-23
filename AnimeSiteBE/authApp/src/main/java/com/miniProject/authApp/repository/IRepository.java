package com.miniProject.authApp.repository;

import com.miniProject.authApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository extends JpaRepository<User,String> {

    public User findByEmailAndPassword(String email,String password);
}
