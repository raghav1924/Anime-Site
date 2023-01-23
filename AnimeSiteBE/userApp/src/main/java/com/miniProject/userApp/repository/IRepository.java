package com.miniProject.userApp.repository;

import com.miniProject.userApp.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository extends MongoRepository<User,String> {


}
