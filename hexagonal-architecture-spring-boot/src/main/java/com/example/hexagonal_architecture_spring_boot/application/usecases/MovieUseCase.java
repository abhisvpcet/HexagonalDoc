package com.example.hexagonal_architecture_spring_boot.application.usecases;


import com.example.hexagonal_architecture_spring_boot.application.dao.MovieDao;
import com.example.hexagonal_architecture_spring_boot.application.dto.NewMovieDto;
import com.example.hexagonal_architecture_spring_boot.domain.Movie;
import com.example.hexagonal_architecture_spring_boot.infrastructure.exception.MovieAlreadyExistException;
import com.example.hexagonal_architecture_spring_boot.infrastructure.exception.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Component
public class MovieUseCase {

    @Autowired
    private MovieDao movieDao;

    public String saveMovie(NewMovieDto newMovieDto) throws MovieAlreadyExistException {
        var isPresent = movieDao.findMovieByTitle(newMovieDto.title()).isPresent();
        if (isPresent) {
            throw new MovieAlreadyExistException("Movie is already present");
        }
        movieDao.saveMovie(newMovieDto);

        return "movie saved succesfully";
    }

    public List<Movie> getAllMovie(){
        return movieDao.findAllMovies();
    }

    public Movie getMovieByTitle(String movieTitle){
        return movieDao.findMovieByTitle(movieTitle).orElseThrow(
                ()-> new MovieNotFoundException("movie is not present")
        );
    }

    public String updateMovie(Movie newMovie) throws MovieAlreadyExistException{

        var isPresent = movieDao.findMovieByTitle(newMovie.title()).isPresent();
        if (!isPresent) {
            throw new MovieNotFoundException("movie is not present");
        }
        movieDao.updateMovie(newMovie);
        return "Movie is updated";

    }

    public void deleteMovie(Movie movieTitle){
        movieDao.deleteMovie(movieTitle);
    }

}
