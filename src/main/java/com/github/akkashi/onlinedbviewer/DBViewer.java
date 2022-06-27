package com.github.akkashi.onlinedbviewer;

import com.github.akkashi.onlinedbviewer.model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: OnlineDBViewer
 * Created by Akkashi
 * on 24/06/2022 at 09:50
 */
public class DBViewer {
    private final Connection connection;

    private final List<Country> countries = new ArrayList<>();

    /**
     * Creates a connection to the database.
     * @param connection Connection to the database
     */
    public DBViewer(Connection connection) {
        System.out.println("Connecting to database...");
        this.connection = connection;
        System.out.println("Connected to database.");
    }

    /**
     * Initializes the database.
     */
    public void initDatabase() {
        System.out.println("Initializing database...");
        try {
            final Statement statement = this.connection.createStatement();
            final String sql = "SELECT * FROM countries";
            final ResultSet set = statement.executeQuery(sql);

            while (set.next()) {
                final int id = set.getInt("id");
                final String name = set.getString("name");
                final String capitalCity = set.getString("capital_city");

                this.countries.add(new Country(id, name, capitalCity));
            }

        } catch (SQLException e) {
            System.out.println("Error during initialization of database.");
            e.printStackTrace();
        }

        System.out.println("Initialized database.");
    }

    /**
     * Disconnects from the database.
     * (Not used)
     */
    public void disconnect() {
        System.out.println("Disconnecting from database...");
        try {
            this.connection.close();
            System.out.println("Disconnected from database.");
        } catch (Exception e) {
            System.out.println("Disconnection from database failed.");
            e.printStackTrace();
        }
    }

    public List<Country> getCountries() {
        return this.countries;
    }
}
