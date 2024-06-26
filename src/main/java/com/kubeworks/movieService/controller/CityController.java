package com.kubeworks.movieService.controller;

import com.kubeworks.movieService.business.abstracts.CityService;
import com.kubeworks.movieService.entity.City;
import com.kubeworks.movieService.entity.CityMovie;
import com.kubeworks.movieService.entity.dto.CityRequestDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie/cities/")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("getCitiesByMovieId/{movieId}")
    public List<City> getCitiesByMovieId(@PathVariable int movieId) {
        return cityService.getCitiesByMovieId(movieId);
    }

    @GetMapping("getCitiesByMyBatis/{movieId}")
    public List<CityMovie> getCitiesByMyBatis(@PathVariable int movieId) {
        return cityService.getCitiesByMyBatis(movieId);
    }

    @GetMapping("getall")
    public List<City> getall() {
        return cityService.getall();
    }

    @PostMapping("add")
    @CircuitBreaker(name="city", fallbackMethod = "fallback")
    @Retry(name="city")
    public void add(@RequestBody CityRequestDto cityRequestDto) {
        cityService.add(cityRequestDto);
    }

    private void fallback(CityRequestDto cityRequestDto, RuntimeException runtimeException) { }

}
