package com.idorsia.research.osiris;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DBConfiguration {
    @Profile("test")
    @Bean
    public DataSource testDatabaseConnection() {
        DataSource dataSource = DataSourceBuilder
                .create()
                .username("osiris")
                .password("fY4_AbX$KWcjdHNF")
                .url("jdbc:oracle:thin:@hypnos-test.idorsia.com:1521:TESTACT0")
                .build();
        return dataSource;
    }

    @Profile("production")
    @Bean
    public DataSource prodDatabaseConnection() {
        DataSource dataSource = DataSourceBuilder
                .create()
                .username("osiris")
                .password("fY4_AbX$KWcjdHNF")
                .url("jdbc:oracle:thin:@hypnos.idorsia.com:1521:ACT0")
                .build();
        return dataSource;
    }
}
