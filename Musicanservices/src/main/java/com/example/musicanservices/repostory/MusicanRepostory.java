package com.example.musicanservices.repostory;


import com.example.musicanservices.entity.Musican;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicanRepostory extends JpaRepository<Musican,Long> {
}
