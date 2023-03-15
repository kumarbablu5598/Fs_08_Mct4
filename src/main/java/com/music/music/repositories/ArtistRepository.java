package com.music.music.repositories;

import com.music.music.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Iterable<Artist> findByNameContainingIgnoreCase(String name);
}