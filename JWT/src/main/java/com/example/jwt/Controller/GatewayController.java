package com.example.jwt.Controller;

import com.example.jwt.Repostory.JwtResponse;
import com.example.jwt.entity.Musican;
import com.example.jwt.entity.SignupDto;
import com.example.jwt.entity.Singer;
import com.example.jwt.entity.Users;
import com.example.jwt.service.GatewayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/gateway")
@Slf4j
public class GatewayController {
    @Autowired
    private GatewayService gatewayService;

    @GetMapping ("/musican/getById/{id}")
    public Musican findMusican(@PathVariable Long id) {
        return gatewayService.getOrderById(id);
    }
    @PostMapping("/musican/save")
    public  Musican saveMusican(@RequestBody Musican musican){
        return gatewayService.createMusican(musican);
    }
    @GetMapping ("/singer/getById/{id}")
    public Singer findSinger(@PathVariable Long id) {
        return gatewayService.getSingerById(id);
    }
    @PostMapping("/singer/save")
    public  Singer saveSinger(@RequestBody Singer singer){
        return gatewayService.createSinger(singer);
    }
    @GetMapping ("/user/getById/{id}")
    public Users findUser(@PathVariable Long id) {
        return gatewayService.getUserById(id);
    }
    @PostMapping("/user/save")
    public  Users saveUser(@RequestBody Users users){
        return gatewayService.createUser(users);
    }


}
