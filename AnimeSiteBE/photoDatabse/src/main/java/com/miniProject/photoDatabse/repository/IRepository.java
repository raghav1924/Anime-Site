package com.miniProject.photoDatabse.repository;

import com.miniProject.photoDatabse.domain.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository extends MongoRepository<Photo,String> {

    public Photo findByAnimeName(String animeName);


}
