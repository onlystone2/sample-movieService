package com.kaankaplan.movieService.business.abstracts;

import com.kaankaplan.movieService.entity.City;
import com.kaankaplan.movieService.entity.CityMovie;
import com.kaankaplan.movieService.entity.dto.CityRequestDto;

import java.util.List;

public interface CityService {

    List<City> getCitiesByMovieId(int movieId);

    List<CityMovie> getCitiesByMyBatis(int movieId);

    List<City> getall();

    void add(CityRequestDto cityRequestDto);
}
