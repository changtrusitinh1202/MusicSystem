package com.example.singerservice.controller;

import com.example.singerservice.entity.Singer;
import com.example.singerservice.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private SingerService singerService;

    @PostMapping("/findById/{id}")
    public Singer getById( @PathVariable Long id) {
        return singerService.findById(id);
    }

}
