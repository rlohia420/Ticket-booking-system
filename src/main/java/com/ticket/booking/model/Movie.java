package com.ticket.booking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Movie {

    private final String id;
    private final String name;

    public Movie(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    //Other metadata
}
