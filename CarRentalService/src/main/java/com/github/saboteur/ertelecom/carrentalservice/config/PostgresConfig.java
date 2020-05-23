package com.github.saboteur.ertelecom.carrentalservice.config;

import com.github.saboteur.ertelecom.carrentalservice.config.properties.PostgresProperties;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(PostgresProperties.class)
public class PostgresConfig {

    @Autowired
    private PostgresProperties postgresProperties;

    @Bean
//    @FlywayDataSource
    public DataSource dataSource() {
        return new HikariDataSource(postgresProperties);
    }

}
