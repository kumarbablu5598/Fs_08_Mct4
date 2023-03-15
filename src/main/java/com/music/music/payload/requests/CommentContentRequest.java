package com.music.music.payload.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentContentRequest {

    @NotBlank(message = "Comment content cannot be blank")
    @Size(max = 255, message = "Comment should be of maximum 255 characters")
    private String content;
}