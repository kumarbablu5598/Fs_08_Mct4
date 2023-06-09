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
@Cache(region = "albumCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String album_art_url;

    @ManyToOne(fetch = FetchType.EAGER)
    private Artist artist;

    @JacksonIdSerializer
    @Cache(region = "albumCache", usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void removeSong(Song song) {
        this.songs.remove(song);
    }
}