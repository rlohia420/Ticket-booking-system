package com.ticket.booking.controller;

import com.ticket.booking.model.Movie;
import com.ticket.booking.model.Screen;
import com.ticket.booking.model.Seat;
import com.ticket.booking.model.Show;
import com.ticket.booking.services.MovieService;
import com.ticket.booking.services.SeatAvailabilityService;
import com.ticket.booking.services.ShowService;
import com.ticket.booking.services.TheatreService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ShowController {
    private final SeatAvailabilityService seatAvailabilityService;
    private final ShowService showService;
    private final TheatreService theatreService;
    private final MovieService movieService;

    public ShowController(SeatAvailabilityService seatAvailabilityService, ShowService showService, TheatreService theatreService, MovieService movieService) {
        this.seatAvailabilityService = seatAvailabilityService;
        this.showService = showService;
        this.theatreService = theatreService;
        this.movieService = movieService;
    }

    public String createShow(@NonNull final String movieId, @NonNull final String screenId, @NonNull final Date startTime,
                             @NonNull final Integer durationInSeconds) {
        final Screen screen = theatreService.getScreen(screenId);
        final Movie movie = movieService.getMovie(movieId);
        return showService.createShow(movie, screen, startTime, durationInSeconds).getId();
    }

    public List<String> getAvailableSeats(@NonNull final String showId) {
        final Show show = showService.getShow(showId);
        final List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show);
        return availableSeats.stream().map(Seat::getId).collect(Collectors.toList());
    }
}
