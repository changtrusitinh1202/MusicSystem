package com.example.musicanservices.service;


import com.example.musicanservices.entity.Musican;
import org.springframework.stereotype.Service;

@Service
public interface MusicanService {
    Musican findbyId(Long id);

    Musican save (Musican musican);
}
