package com.example.artistservice.controller;

import com.example.artistservice.config.RestTemplateConfig;
import com.example.artistservice.entity.Artist;
import com.example.artistservice.repository.ArtistRepository;
import com.example.artistservice.service.ArtistService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private RestTemplateConfig restTemplate;

    @Autowired
    private RetryTemplate retryTemplate;

    private Bucket bucket = null;

    @GetMapping("/albums")
    public Object getForObjectAlbum(){
        String url = "http://localhost:8082/albums";
        return retryTemplate.execute(context -> restTemplate.getForObject(url, Object.class));
    }

    @GetMapping
    public List<Artist> getAllArtists() {
        Refill refill = Refill.intervally(5, Duration.ofMinutes(1));
        Bandwidth limit = Bandwidth.classic(5, refill);
        bucket = Bucket.builder()
                .addLimit(limit)
                .build();

        return artistService.getAllArtists();
    }


    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable Long id) {
        return artistService.getArtistById(id);
    }

    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.createArtist(artist);
    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
    }
}
