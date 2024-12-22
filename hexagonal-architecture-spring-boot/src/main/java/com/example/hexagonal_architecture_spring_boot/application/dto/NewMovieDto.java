package com.example.hexagonal_architecture_spring_boot.application.dto;

import java.time.LocalDate;

public record NewMovieDto(
        String title,
        String description,
        LocalDate releaseDate,
        String directorName
) {
}
