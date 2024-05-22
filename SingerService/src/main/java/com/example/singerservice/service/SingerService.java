package com.example.singerservice.service;

import com.example.singerservice.entity.Singer;
import com.example.singerservice.repostory.SingerRepostory;
import org.springframework.stereotype.Service;

@Service
public interface SingerService {
    Singer findById(Long id);

}
