package com.example.retry.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class RetryController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RetryTemplate retryTemplate;

    @GetMapping("/artists")
    public Object getForObjectArtist() {
        String url = "http://localhost:8081/artists";
        return retryTemplate.execute(context -> restTemplate.getForObject(url, Object.class));
    }

    @GetMapping("/artists/{id}")
    public Object getForObjectArtistById(@PathVariable Long id) {
        String url = "http://localhost:8081/artists/" + id;
        return retryTemplate.execute(context -> restTemplate.getForObject(url, Object.class));
    }

}
