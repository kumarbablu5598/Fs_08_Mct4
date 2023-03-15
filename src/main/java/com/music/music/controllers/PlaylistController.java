package com.music.music.controllers;

import com.music.music.domain.Playlist;
import com.music.music.domain.User;
import com.music.music.payload.requests.PlaylistNameRequest;
import com.music.music.services.PlaylistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/playlists")
@CrossOrigin
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    @GetMapping("")
    public Iterable<Playlist> getAllPlaylists(Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        return playlistService.findAllPlaylistsByUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlaylistById(@PathVariable Long id, Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        Playlist playlist = playlistService.findPlaylistByIdAndUser(id, user);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public Iterable<Playlist> getPlaylistsByName(@PathVariable String name, Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        return playlistService.findPlaylistsByNameAndUser(name, user);
    }

    @PostMapping("")
    public ResponseEntity<?> createPlaylistById(@Valid @RequestBody PlaylistNameRequest playlistNameRequest,
                                                Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        Playlist playlist = playlistService.savePlaylist(playlistNameRequest.getName(), user);
        return new ResponseEntity<>(playlist, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePlaylistById(@PathVariable Long id, @Valid @RequestBody PlaylistNameRequest playlistNameRequest,
                                                Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        Playlist playlist = playlistService.updatePlaylistById(playlistNameRequest.getName(), id, user);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlaylistById(@PathVariable Long id, Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        playlistService.deletePlaylistById(id, user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{playlistId}/song/{songId}")
    public ResponseEntity<?> addSongToPlaylistById(@PathVariable Long playlistId, @PathVariable Long songId,
                                                   Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        Playlist playlist = playlistService.addSongById(playlistId, songId, user);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @DeleteMapping("/{playlistId}/song/{songId}")
    public ResponseEntity<?> removeSongFromPlaylistById(@PathVariable Long playlistId, @PathVariable Long songId,
                                                        Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        Playlist playlist = playlistService.removeSongById(playlistId, songId, user);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }
}