package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Announcement;
import com.example.service.AnnouncementService;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @PostMapping("/post")
    public ResponseEntity<Announcement> postAnnouncement(@RequestBody Announcement announcement) {
        return ResponseEntity.ok(announcementService.postAnnouncement(announcement));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Announcement>> getAnnouncements() {
        return ResponseEntity.ok(announcementService.getAnnouncements());
    }
}
