package com.example.musicanservice.service;

import com.example.musicanservice.entity.Musican;
import com.example.musicanservice.repostory.MusicanRepostory;
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
}
