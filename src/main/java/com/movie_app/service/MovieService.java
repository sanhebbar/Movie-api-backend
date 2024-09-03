package com.movie_app.service;

import com.movie_app.entity.Movie;
import com.movie_app.repo.MovieRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
     private MovieRepo movieRepo;
    public List<Movie> getAllMovies(){
        return movieRepo.findAll();
    }


    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return movieRepo.findMovieByImdbId(imdbId);
    }
}
