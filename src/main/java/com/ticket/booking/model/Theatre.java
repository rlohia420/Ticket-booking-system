package com.ticket.booking.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private final String id;
    private final String name;
    private final List<Screen> screens;
    //Other theatre metadata.

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public Theatre(@NonNull final String id, @NonNull final String name) {
        this.id = id;
        this.name = name;
        this.screens = new ArrayList<>();
    }

    public void addScreen(@NonNull final  Screen screen) {
        screens.add(screen);
    }
}
