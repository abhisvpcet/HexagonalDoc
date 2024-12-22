package com.example.hexagonal_architecture_spring_boot.adapters.in.web;

import com.example.hexagonal_architecture_spring_boot.adapters.out.mysqlJDBC.entities.MovieEntity;
import com.example.hexagonal_architecture_spring_boot.application.dto.NewMovieDto;
import com.example.hexagonal_architecture_spring_boot.application.usecases.MovieUseCase;
import com.example.hexagonal_architecture_spring_boot.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {


    @Autowired
    private MovieUseCase movieUseCase;

    @GetMapping
    public ResponseEntity<?> getAllMovies(){
        return ResponseEntity.ok(movieUseCase.getAllMovie());
    }

    @PostMapping
    public ResponseEntity<?> saveMovies(@RequestBody NewMovieDto movieEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCase.saveMovie(movieEntity));
    }

    @PutMapping
    public ResponseEntity<?> updateMovies(@RequestBody Movie movieEntityDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCase.updateMovie(movieEntityDto));
    }


    @DeleteMapping("/{oldMovieTitle}")
    public void deleteMovies(@PathVariable String oldMovieTitle){
        movieUseCase.deleteByTitle(oldMovieTitle);
    }


}
