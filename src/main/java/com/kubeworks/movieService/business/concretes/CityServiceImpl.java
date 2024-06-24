package com.kubeworks.movieService.business.concretes;

import com.kubeworks.movieService.business.abstracts.CityService;
import com.kubeworks.movieService.business.abstracts.MovieService;
import com.kubeworks.movieService.dao.CityDao;
import com.kubeworks.movieService.dao.mapper.CityMapper;
import com.kubeworks.movieService.entity.City;
import com.kubeworks.movieService.entity.CityMovie;
import com.kubeworks.movieService.entity.Movie;
import com.kubeworks.movieService.entity.dto.CityRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityDao cityDao;
    private final MovieService movieService;
    private final WebClient.Builder webClientBuilder;
    private final CityMapper cityMapper;


    @Override
    public List<City> getCitiesByMovieId(int movieId) {
        return cityDao.getCitiesByMovieMovieId(movieId);
    }

    @Override
    public List<CityMovie> getCitiesByMyBatis(int movieId) {
        return cityMapper.getCitiesByMovieMovieId(movieId);
    }

    @Cacheable(value = "cities")
    @Override
    public List<City> getall() {
        return cityDao.findAll(Sort.by(Sort.Direction.ASC, "cityName"));
    }

    @CacheEvict(value = "cities", allEntries = true)
    @Override
    public void add(CityRequestDto cityRequestDto) {
        Boolean result = webClientBuilder.build().get()
                .uri("http://USERSERVICE/api/user/isUserAdmin")
                .header("Authorization", "Bearer " + cityRequestDto.getToken())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        if (result) {
            Movie movie = movieService.getMovieById(cityRequestDto.getMovieId());
            for (String cityName: cityRequestDto.getCityNameList()) {
                City city = City.builder()
                        .cityName(cityName)
                        .movie(movie)
                        .build();
                cityDao.save(city);
            }
        }
    }
}
