package com.kubeworks.movieService.dao;

import com.kubeworks.movieService.entity.MovieSaloonTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieSaloonTimeDao extends JpaRepository<MovieSaloonTime, Integer> {

    List<MovieSaloonTime> getMovieSaloonTimeBySaloonSaloonIdAndMovieMovieId(int saloonId, int movieId);

}
