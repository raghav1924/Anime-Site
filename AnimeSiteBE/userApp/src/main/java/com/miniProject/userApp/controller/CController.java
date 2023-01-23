package com.miniProject.userApp.controller;


import com.miniProject.userApp.domain.Anime;
import com.miniProject.userApp.domain.User;
import com.miniProject.userApp.repository.IRepository;
import com.miniProject.userApp.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/userApp")
public class CController {
    @Autowired
    private IService iService;
    @Autowired
    private IRepository iRepository;


    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user){
        user.setAnimeList(new ArrayList<>());
        return new ResponseEntity<>(iService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<>(iService.getAllUserDetails(),HttpStatus.OK);
    }

    @PutMapping("/addAnime")
    public ResponseEntity<?> addAnime(@RequestBody Anime anime, HttpServletRequest httpServletRequest){

        String email=(String) httpServletRequest.getAttribute("userEmail");
        return new ResponseEntity<>(iService.addAnime(anime,email),HttpStatus.OK);
    }
    @GetMapping("/userDetails")
    public ResponseEntity<?> getUserDetails(HttpServletRequest request){
        String email=(String) request.getAttribute("userEmail");
        System.out.println("inside "+email);
        return new ResponseEntity<>(iService.getUserDetails(email),HttpStatus.OK);
    }

    @DeleteMapping("/deleteAnime")
    public ResponseEntity<?> deleteAnime(@RequestBody String animeName, HttpServletRequest httpServletRequest){
        String email=(String) httpServletRequest.getAttribute("userEmail");
        return new ResponseEntity<>(iService.deleteAnime(animeName,email),HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email){
        iService.deleteUser(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
