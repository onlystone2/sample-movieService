package com.kubeworks.movieService.business.abstracts;

import com.kubeworks.movieService.entity.City;
import com.kubeworks.movieService.entity.CityMovie;
import com.kubeworks.movieService.entity.dto.CityRequestDto;

import java.util.List;

public interface CityService {

    List<City> getCitiesByMovieId(int movieId);

    List<CityMovie> getCitiesByMyBatis(int movieId);

    List<City> getall();

    void add(CityRequestDto cityRequestDto);
}
