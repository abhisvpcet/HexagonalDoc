package com.example.hexagonal_architecture_spring_boot.application.dao;

import com.example.hexagonal_architecture_spring_boot.application.dto.NewMovieDto;
import com.example.hexagonal_architecture_spring_boot.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDao {

    Optional<Movie> findMovieByTitle(String title);

    List<Movie> findAllMovies();

    void saveMovie(NewMovieDto movie);

    void updateMovie(Movie newMovie);

    void deleteByTitle(String oldMovieTitle);
}
