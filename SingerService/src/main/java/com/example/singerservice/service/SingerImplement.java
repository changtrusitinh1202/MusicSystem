package com.example.singerservice.service;

import com.example.singerservice.controller.SingerController;
import com.example.singerservice.entity.Singer;
import com.example.singerservice.repostory.SingerRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingerImplement implements SingerService{

    @Autowired
    private SingerRepostory singerRepostory;

    @Override
    public Singer findById(Long id) {
        return singerRepostory.findById(id).get();
    }

    @Override
    public Singer addSinger(Singer singer) {
        return singerRepostory.save(singer);
    }
}
