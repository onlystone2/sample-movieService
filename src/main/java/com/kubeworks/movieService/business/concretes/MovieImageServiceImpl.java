package com.kubeworks.movieService.business.concretes;

import com.kubeworks.movieService.business.abstracts.MovieImageService;
import com.kubeworks.movieService.business.abstracts.MovieService;
import com.kubeworks.movieService.dao.MovieImageDao;
import com.kubeworks.movieService.entity.Movie;
import com.kubeworks.movieService.entity.MovieImage;
import com.kubeworks.movieService.entity.dto.ImageRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@RequiredArgsConstructor
public class MovieImageServiceImpl implements MovieImageService {

    private final MovieImageDao movieImageDao;
    private final MovieService movieService;
    private final WebClient.Builder webClientBuilder;


    @Override
    public MovieImage addMovieImage(ImageRequestDto imageRequestDto) {

        Boolean result = webClientBuilder.build().get()
                .uri("http://USERSERVICE/api/user/isUserAdmin")
                .header("Authorization", "Bearer " + imageRequestDto.getToken())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

        if (result) {
            Movie movie = movieService.getMovieById(imageRequestDto.getMovieId());

            MovieImage image = new MovieImage();
            image.setImageUrl(image.getImageUrl());
            image.setMovie(movie);

            return movieImageDao.save(image);
        }
        throw new RuntimeException("Yetki hatası");
    }
}
