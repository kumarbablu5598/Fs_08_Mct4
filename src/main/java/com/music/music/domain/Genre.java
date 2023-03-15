package com.music.music.domain;

import com.music.music.annotations.JacksonIdSerializer;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Cache(region = "genreCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String photo_url;

    @JacksonIdSerializer
    @Cache(region = "genreCache", usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void removeSong(Song song) {
        this.songs.remove(song);
    }
}
