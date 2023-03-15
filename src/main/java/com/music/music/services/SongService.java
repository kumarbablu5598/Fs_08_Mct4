package com.music.music.services;

import com.music.music.domain.Song;
import com.music.music.exceptions.NotFoundException;
import com.music.music.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    public Song findSongById(Long id) {

        return songRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Song ID: %s does not exist", id)));
    }

    public Iterable<Song> findAllSongs() {

        return songRepository.findAll();
    }

    public Iterable<Song> findSongsByName(String name) {

        return songRepository.findByNameContainingIgnoreCase(name);
    }
}