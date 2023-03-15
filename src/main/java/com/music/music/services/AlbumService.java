package com.music.music.services;

import com.music.music.domain.Album;
import com.music.music.exceptions.NotFoundException;
import com.music.music.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;

    public Album findAlbumById(Long id) {

        return albumRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Album ID: %s does not exist", id)));
    }

    public Iterable<Album> findAllAlbums() {

        return albumRepository.findAll();
    }

    public Iterable<Album> findAlbumsByName(String name) {

        return albumRepository.findByNameContainingIgnoreCase(name);
    }
}