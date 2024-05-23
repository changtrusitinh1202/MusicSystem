package com.example.jwt.service;

import com.example.jwt.entity.Musican;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class MusicanService {
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
}
