package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
public class DatabaseConfig {
    
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
            .url("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1")
            .username("sa")
            .password("password")
            .driverClassName("org.h2.Driver")
            .build();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabase(Database.H2);

        return adapter;
    }
}
