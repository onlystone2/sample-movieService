package com.kubeworks.movieService.dao.mapper;

import com.kubeworks.movieService.entity.CityMovie;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CityMapper {
    List<CityMovie> getCitiesByMovieMovieId(int movieId);
}
