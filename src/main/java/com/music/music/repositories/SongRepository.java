package com.music.music.repositories;

import com.music.music.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    Iterable<Song> findByNameContainingIgnoreCase(String name);
}