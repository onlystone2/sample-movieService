package com.kubeworks.movieService.business.abstracts;

import com.kubeworks.movieService.entity.Actor;
import com.kubeworks.movieService.entity.dto.ActorRequestDto;

import java.util.List;

public interface ActorService {

    List<Actor> getActorsByMovieId(int movieId);

    List<Actor> getall();

    void addActors(ActorRequestDto actorRequestDto);
}
