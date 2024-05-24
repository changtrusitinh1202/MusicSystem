package com.example.singerservice.controller;

import com.example.singerservice.entity.Singer;
import com.example.singerservice.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private SingerService singerService;

    @GetMapping("/findById/{id}")
    public Singer getById( @PathVariable Long id) {
        return singerService.findById(id);
    }
    @PostMapping("/save")
    public Singer CreateSinger(@RequestBody Singer singer){
        return singerService.addSinger(singer);
    }

}
