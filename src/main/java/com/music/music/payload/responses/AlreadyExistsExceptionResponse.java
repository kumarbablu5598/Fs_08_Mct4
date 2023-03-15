package com.music.music.payload.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlreadyExistsExceptionResponse {

    private String alreadyExists;
}