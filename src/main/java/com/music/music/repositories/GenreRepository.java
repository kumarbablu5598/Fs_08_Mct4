package com.music.music.repositories;

import com.music.music.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    Iterable<Genre> findByNameContainingIgnoreCase(String name);
}