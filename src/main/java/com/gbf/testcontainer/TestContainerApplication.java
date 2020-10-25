package com.gbf.testcontainer;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class TestContainerApplication {

   /* @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("src/test/resources/liquibase-changeLog.xml");
        //liquibase.setDataSource(dataSource());
        return liquibase;
    }*/


    public static void main(String[] args) {
        SpringApplication.run(TestContainerApplication.class, args);
    }
}
