package com.ticket.booking.controller;

import com.ticket.booking.model.Seat;
import com.ticket.booking.model.Show;
import com.ticket.booking.services.BookingService;
import com.ticket.booking.services.ShowService;
import com.ticket.booking.services.TheatreService;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class BookingController {
    private final ShowService showService;
    private final BookingService bookingService;

    public BookingController(ShowService showService, BookingService bookingService, TheatreService theatreService) {
        this.showService = showService;
        this.bookingService = bookingService;
        this.theatreService = theatreService;
    }

    private final TheatreService theatreService;

    public String createBooking(@NonNull final String userId, @NonNull final String showId,
                                @NonNull final List<String> seatsIds) {
        final Show show = showService.getShow(showId);
        final List<Seat> seats = seatsIds.stream().map(theatreService::getSeat).collect(Collectors.toList());
        return bookingService.createBooking(userId, show, seats).getId();
    }
}
