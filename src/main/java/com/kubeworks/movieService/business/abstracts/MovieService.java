package com.kubeworks.movieService.business.abstracts;

import com.kubeworks.movieService.entity.Movie;
import com.kubeworks.movieService.entity.dto.MovieRequestDto;
import com.kubeworks.movieService.entity.dto.MovieResponseDto;

import java.util.List;

public interface MovieService {

    List<MovieResponseDto> getAllDisplayingMoviesInVision();

    List<MovieResponseDto> getAllComingSoonMovies();

    MovieResponseDto getMovieByMovieId(int movieId);

    Movie getMovieById(int movieId);

    Movie addMovie(MovieRequestDto movieRequestDto);
}
