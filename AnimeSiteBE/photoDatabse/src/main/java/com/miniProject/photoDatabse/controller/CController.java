package com.miniProject.photoDatabse.controller;


import com.miniProject.photoDatabse.domain.Photo;
import com.miniProject.photoDatabse.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/photodb")
public class CController {
    @Autowired
    private IService iService;



    @PostMapping("/addImage")
    public ResponseEntity<?> addPhoto(@RequestParam("animeName") String animeName,@RequestParam("lang") String lang,@RequestParam("releaseData") String releaseData,@RequestParam("genre") String genre,@RequestParam("director") String director,@RequestParam("rating") String rating,@RequestParam("descp") String descp, @RequestParam("image")MultipartFile image)throws IOException {
        return new ResponseEntity<>(iService.addPhoto(animeName,lang,releaseData,genre,director,rating,descp, image), HttpStatus.CREATED);
    }

    @GetMapping("/animes")
    public ResponseEntity<?> getAllPhoto(){
        return new ResponseEntity<>(iService.getAllPhoto(),HttpStatus.OK);
    }
    @GetMapping("/anime/{animeName}")
    public ResponseEntity<?> getPhoto(@PathVariable String animeName){
        return new ResponseEntity<>(iService.getPhoto(animeName),HttpStatus.OK);

    }

    @DeleteMapping("/deleteAnime/{id}")
    public ResponseEntity<?> deleteAnime(@PathVariable String id){
        return new ResponseEntity<>(iService.deletePhoto(id),HttpStatus.OK);
    }

}
