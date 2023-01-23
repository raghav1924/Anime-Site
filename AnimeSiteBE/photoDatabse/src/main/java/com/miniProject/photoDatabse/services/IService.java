package com.miniProject.photoDatabse.services;


import com.miniProject.photoDatabse.domain.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IService {

   public String addPhoto(String animeName,String lang,String releaseData,String genre,String director,String rating,String descp, MultipartFile file)throws IOException;
   public boolean deletePhoto(String id);
   public Photo getPhoto(String animeName);
   public List<Photo> getAllPhoto();

}
