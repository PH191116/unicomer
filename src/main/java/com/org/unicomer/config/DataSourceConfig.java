package com.org.unicomer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.core.env.Environment;


import javax.sql.DataSource;

/**
 * Configurar fuente de datos creando los objeto respectivos para cada datasource
 */
@Configuration
public class DataSourceConfig {
    @Autowired
    Environment env;
    @Primary
    @Bean(name = "costaRicaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource costaRicaDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        return dataSource;    }
    @Bean(name = "guatemalaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.guatemala")
    public DataSource guatemalaDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.guatemala.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.guatemala.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.guatemala.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.guatemala.password"));

        return dataSource;    }
    @Bean(name = "jamaicaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.jamaica")
    public DataSource jamaicaDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.jamaica.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.jamaica.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.jamaica.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.jamaica.password"));

        return dataSource;     }
}
