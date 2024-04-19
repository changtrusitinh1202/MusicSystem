package com.example.product.repository;


import com.example.product.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Singer, Long> {
}
