package com.ticket.booking.controller;

import com.ticket.booking.services.MovieService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

public class MovieController {
    final private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public String createMovie(@NonNull final String movieName) {
        return movieService.createMovie(movieName).getId();
    }

}
