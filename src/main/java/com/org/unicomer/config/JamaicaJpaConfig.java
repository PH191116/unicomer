package com.org.unicomer.config;

import com.org.unicomer.repository.jamaica.ICandidatoJMRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.org.unicomer.repository.jamaica"},
        entityManagerFactoryRef = "jamaicaEntityManagerFactory",
        transactionManagerRef = "jamaicaTransactionManager")
public class JamaicaJpaConfig {
    @Bean(name = "jamaicaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean jamaicaEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                              @Qualifier("jamaicaDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.org.unicomer.models")
                .build();
    }
    @Bean(name = "jamaicaTransactionManager")
    public PlatformTransactionManager jamaicaTransactionManager(@Qualifier("jamaicaEntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactory.getObject()));
    }
}