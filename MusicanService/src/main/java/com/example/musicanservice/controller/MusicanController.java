package com.example.musicanservice.controller;

import com.example.musicanservice.entity.Musican;
import com.example.musicanservice.service.MusicanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musican")
public class MusicanController {
    @Autowired
    private MusicanService musicanService;

    @GetMapping("/findById/{id}")
    public Musican getById(@PathVariable Long id) {
        return musicanService.findbyId(id);
    }

    @PostMapping ("/save")
    public Musican save(@RequestBody Musican musican){
        return  musicanService.save(musican);
    }

}
