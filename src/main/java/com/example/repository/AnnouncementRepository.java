package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Announcement;

public interface AnnouncementRepository extends MongoRepository<Announcement,String> {
    
}
