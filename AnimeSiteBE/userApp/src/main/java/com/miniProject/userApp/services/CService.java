package com.miniProject.userApp.services;

import com.miniProject.userApp.domain.Anime;
import com.miniProject.userApp.domain.User;
import com.miniProject.userApp.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CService implements IService{
    @Autowired
    private IRepository iRepository;


    @Override
    public User addUser(User user) {
        return iRepository.insert(user);
    }

    @Override
    public String addAnime(Anime anime, String email) {

            User user=iRepository.findById(email).get();
            if(user.getAnimeList()!=null) {
                for (Anime p : user.getAnimeList()) {
                    if (p.getAnimeName().equalsIgnoreCase(anime.getAnimeName())) {
                        return "Anime Already present";
                    } else {
                        List<Anime> newlist = user.getAnimeList();
                        newlist.add(anime);
                        user.setAnimeList(newlist);
                        iRepository.save(user);
                        return "Anime Added successful!";
                    }
                }
            }else {
                List<Anime> newlist1 = new ArrayList<>();
                newlist1.add(anime);
                user.setAnimeList(newlist1);
                iRepository.save(user);
                return "Anime Added successful!";
            }
        return null;
    }

    @Override
    public String deleteAnime(String animeName, String email) {
        User user=iRepository.findById(email).get();
        for (Anime p: user.getAnimeList()) {
            if (p.getAnimeName().equalsIgnoreCase(animeName)){
                List<Anime> newlist=user.getAnimeList();
                newlist.remove(p);
                user.setAnimeList(newlist);
                iRepository.save(user);
                return "Anime delete successful!";

            }else {
                return "Anime Not present";
            }
        }
        return null;
    }

    @Override
    public User getUserDetails(String email) {
        System.out.println("INSIDE SERVICE GETUSER DETAILS "+email);
        return iRepository.findById(email).get();
    }

    @Override
    public List<User> getAllUserDetails() {
        return iRepository.findAll();
    }

    @Override
    public void deleteUser(String email) {
         iRepository.deleteById(email);
    }
}
