package com.example.musicanservice.service;

import com.example.musicanservice.entity.Musican;
import org.springframework.stereotype.Service;

@Service
public interface MusicanService {
    Musican findbyId(Long id);

    Musican save (Musican musican);
}
