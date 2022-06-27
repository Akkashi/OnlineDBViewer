package com.github.akkashi.onlinedbviewer.model;

/**
 * Project: OnlineDBViewer
 * Created by Akkashi
 * on 24/06/2022 at 09:40
 */
public class Country {
    private final int id;
    private final String name;
    private final String capitalCity;

    public Country(int id, String name, String capitalCity) {
        this.id = id;
        this.name = name;
        this.capitalCity = capitalCity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapitalCity() {
        return capitalCity;
    }
}
