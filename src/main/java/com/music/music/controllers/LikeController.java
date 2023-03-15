package com.music.music.controllers;

import com.music.music.domain.Song;
import com.music.music.domain.User;
import com.music.music.services.LikeService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/likes")
@CrossOrigin
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @GetMapping("/songs")
    public Iterable<Song> getAllLikedSongs(Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        return likeService.findAllLikedSongsByUser(user);
    }

    @PutMapping("/songs/{id}")
    public ResponseEntity<?> toggleLikedSongById(@PathVariable Long id, Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        Song song = likeService.toggleLikedSong(id, user);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }
}
