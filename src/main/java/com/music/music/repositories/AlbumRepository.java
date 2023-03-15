package com.music.music.repositories;

import com.music.music.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    Iterable<Album> findByNameContainingIgnoreCase(String name);
}