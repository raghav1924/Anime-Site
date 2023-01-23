package com.miniProject.authApp.services;

import com.miniProject.authApp.domain.SignUpData;
import com.miniProject.authApp.domain.User;

public interface IService {

    public User register(SignUpData signUpData);
    public User login(User user);
    public void deleteUser(String email);
}
