package com.kubeworks.movieService.business.abstracts;

import com.kubeworks.movieService.entity.Director;
import com.kubeworks.movieService.entity.dto.DirectorRequestDto;

import java.util.List;

public interface DirectorService {

    List<Director> getall();

    Director getDirectorById(int directorId);

    Director add(DirectorRequestDto directorRequestDto);
}
