package com.example.singerservice.repostory;

import com.example.singerservice.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepostory extends JpaRepository<Singer, Long> {
}
