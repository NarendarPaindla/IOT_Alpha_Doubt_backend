package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Announcement;
import com.example.repository.AnnouncementRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    public Announcement postAnnouncement(Announcement announcement) {
        announcement.setCreatedAt(LocalDateTime.now());
        return announcementRepository.save(announcement);
    }

    public List<Announcement> getAnnouncements() {
        return announcementRepository.findAll();
    }
}
