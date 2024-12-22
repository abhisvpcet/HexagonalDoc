package com.example.hexagonal_architecture_spring_boot.adapters.out.mysqlJDBC.repositories;

import com.example.hexagonal_architecture_spring_boot.adapters.out.mysqlJDBC.entities.MovieEntity;
import com.example.hexagonal_architecture_spring_boot.application.dao.MovieDao;
import com.example.hexagonal_architecture_spring_boot.application.dto.NewMovieDto;
import com.example.hexagonal_architecture_spring_boot.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class MoviesDaoAdapter implements MovieDao {

    @Autowired
    private MoviesRepository moviesRepository;
    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        return moviesRepository.findMovieByTitle(title);

    }

    @Override
    public List<Movie> findAllMovies() {
         return ((List<MovieEntity>) moviesRepository.findAll())
                  .stream()
                  .map(movieEntity -> new Movie(
                          movieEntity.id(),
                          movieEntity.title(),
                          movieEntity.description(),
                          movieEntity.releaseDate(),
                          movieEntity.directorName()
                  )).toList();

    }

    @Override
    public void saveMovie(NewMovieDto movie) {
        moviesRepository.save(new MovieEntity(
                0,
                movie.title(),
                movie.description(),
                movie.releaseDate(),
                movie.directorName(),
                null
        ));
    }

    @Override
    public void updateMovie(Movie newMovie) {
        moviesRepository.save(new MovieEntity(
                newMovie.id(),
                newMovie.title(),
                newMovie.description(),
                newMovie.releaseDate(),
                newMovie.directorName(),
                null
        ));
    }

    @Override
    public void deleteMovie(Movie oldMovie) {

    }
}
