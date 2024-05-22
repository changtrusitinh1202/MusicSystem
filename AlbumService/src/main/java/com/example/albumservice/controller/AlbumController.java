package com.example.albumservice.controller;

import com.example.albumservice.config.RestTemplateConfig;
import com.example.albumservice.entity.Album;
import com.example.albumservice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @Autowired
    private RestTemplateConfig restTemplate;
    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping("/artist/{artistId}")
    public List<Album> getAlbumsByArtistId(@PathVariable Long artistId) {
        return albumService.getAlbumsByArtistId(artistId);
    }

    @GetMapping("/listArtist/{artistId}")
    public ResponseEntity<Object> getArtistAndAlbums( @PathVariable String artistId) {
        Optional<Album> optionalAlbum = Optional.ofNullable((Album) albumService.getAlbumsByArtistId(2L));
        if(optionalAlbum.isPresent()){
            String artistUrl = "http://localhost:8081/artists/" + artistId;
            Object artist = restTemplate.getForObject(artistUrl, Object.class);

            Map<String, Object> result = new HashMap<>();
            result.put("album", optionalAlbum.get());
            result.put("artist", artist);

            return ResponseEntity.ok().body(result);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{id}")
    public Album getAlbumById(@PathVariable Long id) {
        return albumService.getAlbumById(id);
    }

    @PostMapping
    public Album createAlbum(@RequestBody Album album) {
        return albumService.createAlbum(album);
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
    }

}
