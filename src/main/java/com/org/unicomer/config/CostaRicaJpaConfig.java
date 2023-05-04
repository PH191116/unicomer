package com.org.unicomer.config;

import com.org.unicomer.repository.costarica.ICandidatoCRRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.org.unicomer.repository.costarica"},
        entityManagerFactoryRef = "costaRicaEntityManagerFactory",
        transactionManagerRef = "costaRicaTransactionManager")
public class CostaRicaJpaConfig {

    @Primary
    @Bean(name = "costaRicaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean costaRicaEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                                @Qualifier("costaRicaDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.org.unicomer.models")
                .build();
    }
    @Primary
    @Bean(name = "costaRicaTransactionManager")
    public PlatformTransactionManager costaRicaTransactionManager(@Qualifier("costaRicaEntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactory.getObject()));
    }
}