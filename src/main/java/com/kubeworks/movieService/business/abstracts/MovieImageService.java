package com.kubeworks.movieService.business.abstracts;

import com.kubeworks.movieService.entity.MovieImage;
import com.kubeworks.movieService.entity.dto.ImageRequestDto;


public interface MovieImageService {

    MovieImage addMovieImage(ImageRequestDto imageRequestDto);
}
