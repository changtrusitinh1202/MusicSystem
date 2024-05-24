package com.example.jwt.service;

import com.example.jwt.entity.Musican;
import com.example.jwt.entity.Singer;
import com.example.jwt.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class GatewayService {
    @Autowired
    private  RestTemplate restTemplate;


    public Musican getOrderById(Long id){

        Musican musican = restTemplate.getForObject("http://localhost:8082/musican/findById/"+id, Musican.class);
        return musican;
    }
    public Musican createMusican(Musican musican){
        Musican mu = restTemplate.postForObject("http://localhost:8082/musican/save",musican,Musican.class);
        return mu;
    }

    public Singer getSingerById(Long id){

        Singer singer = restTemplate.getForObject("http://localhost:8083/singer/findById/"+id, Singer.class);
        return singer;
    }
    public Singer createSinger(Singer singer){
        Singer singer1 = restTemplate.postForObject("http://localhost:8082/singer/save",singer,Singer.class);
        return singer1;
    }
    public Users getUserById(Long id){

        Users users = restTemplate.getForObject("http://localhost:8084/user/findById/"+id, Users.class);
        return users;
    }
    public Users createUser(Users users){
        Users users1 = restTemplate.postForObject("http://localhost:8084/user/save",users,Users.class);
        return users1;
    }
}
