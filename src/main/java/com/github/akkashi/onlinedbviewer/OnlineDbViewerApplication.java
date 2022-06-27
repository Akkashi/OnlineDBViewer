package com.github.akkashi.onlinedbviewer;

import com.github.akkashi.onlinedbviewer.config.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class OnlineDbViewerApplication implements CommandLineRunner {
    private DBViewer viewer;
    @Autowired
    private DatabaseConfig databaseConfig;

    /**
     * This method is called when the application starts.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(OnlineDbViewerApplication.class);
        app.run();
    }

    /**
     * Permits to get the DBViewer instance.
     * @return The DBViewer instance.
     */
    public DBViewer getViewer() {
        return this.viewer;
    }

    /**
     * This method is called after the application starts.
     * @param args The command line arguments.
     * @throws Exception If an error occurs.
     */
    @Override
    public void run(String... args) throws Exception {
        this.viewer = new DBViewer(this.databaseConfig.getDataSource().getConnection());
        this.viewer.initDatabase();
    }
}
