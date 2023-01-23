package com.miniProject.authApp.services;


import com.miniProject.authApp.domain.User;

import java.util.Map;

public interface IToken {
    public Map<String,String> genToken(User user);
}
