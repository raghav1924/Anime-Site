package com.miniProject.userApp.services;


import com.miniProject.userApp.domain.Anime;
import com.miniProject.userApp.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IService {

    public User addUser(User user);
    public String addAnime(Anime anime,String email);
    public String deleteAnime(String animeName,String email);

//    public String addImage(String animeName, MultipartFile file)throws IOException;

    public User getUserDetails(String email);

    public List<User> getAllUserDetails();
    public void deleteUser(String email);
}
