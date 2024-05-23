package com.example.jwt.Controller;

import com.example.jwt.Repostory.JwtResponse;
import com.example.jwt.entity.Musican;
import com.example.jwt.entity.SignupDto;
import com.example.jwt.service.MusicanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/musician")
@Slf4j
public class GatewayController {
    @Autowired
    private MusicanService musicanService;

    @GetMapping ("/getById/{id}")
    public Musican signup(@PathVariable Long id) {
        return musicanService.getOrderById(id);
    }
    @PostMapping("/save")
    public  Musican save(@RequestBody Musican musican){
        return musicanService.createMusican(musican);
    }


}
