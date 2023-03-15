package com.music.music.controllers;

import com.music.music.domain.Album;
import com.music.music.services.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/albums")
@CrossOrigin
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping("")
    public Iterable<Album> getAllAlbums() {

        return albumService.findAllAlbums();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAlbumById(@PathVariable Long id) {

        Album album = albumService.findAlbumById(id);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public Iterable<Album> getAlbumsByName(@PathVariable String name) {

        return albumService.findAlbumsByName(name);
    }
}