package com.music.music.services;

import com.music.music.domain.Genre;
import com.music.music.exceptions.NotFoundException;
import com.music.music.repositories.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    public Genre findGenreById(Long id) {

        return genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Genre ID: %s does not exist", id)));
    }

    public Iterable<Genre> findAllGenres() {

        return genreRepository.findAll();
    }

    public Iterable<Genre> findGenresByName(String name) {

        return genreRepository.findByNameContainingIgnoreCase(name);
    }
}