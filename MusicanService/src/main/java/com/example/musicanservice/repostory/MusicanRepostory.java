package com.example.musicanservice.repostory;

import com.example.musicanservice.entity.Musican;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicanRepostory extends JpaRepository<Musican,Long> {
}
