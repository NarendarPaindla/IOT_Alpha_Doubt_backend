package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Doubt;
import com.example.repository.DoubtRepository;

@Service
public class DoubtService {
    @Autowired
    private DoubtRepository doubtRepository;

    public Doubt askDoubt(Doubt doubt){
        doubt.setCreatedAt(LocalDateTime.now());
        return doubtRepository.save(doubt);
    }

    public List<Doubt>  getAllDoubts(){
        return doubtRepository.findAll();
    }

    public Optional<Doubt> addReply(String doubtId,Doubt.Reply reply){
        Optional<Doubt> optional=doubtRepository.findById(doubtId);
        if(optional.isPresent()){
            Doubt doubt=optional.get();
            doubt.getReplies().add(reply);
            doubtRepository.save(doubt);
            return Optional.of(doubt);
        }
        return Optional.empty();
    }

}
