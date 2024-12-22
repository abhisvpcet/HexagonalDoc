package com.example.hexagonal_architecture_spring_boot.domain;

import java.time.LocalDate;

public record Movie(
        long id,
        String title,
        String description,
        LocalDate releaseDate,
        String directorName

) {
}
