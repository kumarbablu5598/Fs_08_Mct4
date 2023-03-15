package com.music.music.payload.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PlaylistNameRequest {

    @NotBlank(message = "Playlist name cannot be blank")
    private String name;
}
