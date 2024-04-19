package com.example.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class BrandController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RetryTemplate retryTemplate;

    @GetMapping("/product")
    public Object getForObjectProduct() {
        String url = "http://localhost:8083/product/product";
        return retryTemplate.execute(context -> restTemplate.getForObject(url, Object.class));
    }
}
