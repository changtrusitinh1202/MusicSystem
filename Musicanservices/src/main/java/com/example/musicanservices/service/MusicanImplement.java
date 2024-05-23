package com.example.musicanservices.service;


import com.example.musicanservices.entity.Musican;
import com.example.musicanservices.repostory.MusicanRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicanImplement implements MusicanService{
    @Autowired
    private MusicanRepostory musicanRepostory;
    @Override
    public Musican findbyId(Long id) {
        return musicanRepostory.findById(id).get();
    }

    @Override
    public Musican save(Musican musican) {
        return musicanRepostory.save(musican);
    }
}
