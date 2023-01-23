package com.miniProject.authApp.controller;


import com.miniProject.authApp.domain.SignUpData;
import com.miniProject.authApp.domain.User;
import com.miniProject.authApp.services.IService;
import com.miniProject.authApp.services.IToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/auth")
public class CController {
    @Autowired
    private IService iService;

    @Autowired
    private IToken iToken;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SignUpData signUpData){
        return new ResponseEntity<>(iService.register(signUpData), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        User user1=iService.login(user);
        if(user1!=null)return new ResponseEntity<>(iToken.genToken(user1),HttpStatus.CREATED);
        else return new ResponseEntity<>("User Not Found",HttpStatus.EXPECTATION_FAILED);
    }
    @DeleteMapping("/deleteUser/{email}")
    public ResponseEntity<?> register(@PathVariable String email){
        iService.deleteUser(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
