package com.github.akkashi.onlinedbviewer.config;

import org.postgresql.Driver;
import org.postgresql.ds.PGSimpleDataSource;
import org.postgresql.ds.common.BaseDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Project: OnlineDBViewer
 * Created by Akkashi
 * on 27/06/2022 at 09:22
 */

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "datasource")
public class DatabaseConfig {

    private String url;
    private String username;
    private String password;
    private String driverClassName;

    public String getUrl() {
        return this.url;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getDriverClassName() {
        return this.driverClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    /**
     * Creates a data source for the database.
     * @return Data source for the database
     */
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .url(this.url)
                .username(this.username)
                .password(this.password)
                .driverClassName(this.driverClassName)
                .type(PGSimpleDataSource.class)
                .build();
    }
}
