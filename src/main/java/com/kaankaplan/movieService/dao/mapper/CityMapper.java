package com.kaankaplan.movieService.dao.mapper;

import com.kaankaplan.movieService.entity.CityMovie;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CityMapper {
    List<CityMovie> getCitiesByMovieMovieId(int movieId);
}
