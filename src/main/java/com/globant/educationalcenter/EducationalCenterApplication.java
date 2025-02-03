package com.globant.educationalcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // to allow auditing dates in Audit Class
public class EducationalCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationalCenterApplication.class, args);
    }

}
