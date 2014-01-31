package com.springapp.repo;

import com.springapp.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {
    @Autowired
    private MongoTemplate mongoTemplate;

    public static final String COLLECTION =  "users";

    public void add(User user) {
        if(!mongoTemplate.collectionExists(User.class)) {
            mongoTemplate.createCollection(User.class);
        }
        mongoTemplate.insert(user, COLLECTION);
    }

    public List<User> getCollection() {
        List<User> list = mongoTemplate.findAll(User.class, COLLECTION);
        return list;
    }

    public void update(User user) {
        mongoTemplate.insert(user, COLLECTION);
    }

    public void delete(User user) {
        mongoTemplate.remove(user);
    }
}