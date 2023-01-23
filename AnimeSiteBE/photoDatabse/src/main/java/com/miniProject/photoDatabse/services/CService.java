package com.miniProject.photoDatabse.services;

import com.miniProject.photoDatabse.domain.Photo;
import com.miniProject.photoDatabse.repository.IRepository;
import com.miniProject.photoDatabse.util.PhotoUtils;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CService implements IService{
    @Autowired
    private IRepository iRepository;


    @Override
    public String addPhoto(String animeName, String lang, String releaseData, String genre, String director, String rating, String descp, MultipartFile file) throws IOException {
        Photo photo=iRepository.insert(Photo.builder()
                .animeName(animeName)
                .type(file.getContentType())
                .lang(lang)
                .releaseData(releaseData)
                .genre(genre)
                .director(director)
                .rating(rating)
                        .descp(descp)
                .image(PhotoUtils.compressImage(file.getBytes())).build());
        if(photo!=null){
            return "image added successfully : "+photo.getId();
        }
        return null;
    }

    @Override
    public boolean deletePhoto(String id) {
         iRepository.deleteById(id);
         return true;
    }

    @Override
    public Photo getPhoto(String animeName) {
        Photo photo=iRepository.findByAnimeName(animeName);
        byte[] image=PhotoUtils.decompressImage(photo.getImage());
        photo.setImage(image);
        return photo;
    }

    @Override
    public List<Photo> getAllPhoto() {
        List<Photo> list = iRepository.findAll();
        for (Photo p:list) {
            byte[] image=PhotoUtils.decompressImage(p.getImage());
            p.setImage(image);
        }
        return list;
    }
}
