package org.nickharle.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.boot.autoconfigure.SpringBootApplication(scanBasePackages = "org.nickharle")
@Configuration                      // Denotes this is the configuration class
//@EnableAutoConfiguration
// Will scan classes to configure the SpringApplicationContext, this stores the beans (hence we can use Dependancy Injection)
//@ComponentScan(basePackages = {"org.nickharle"})
@EnableJpaRepositories(("org.nickharle"))
@EntityScan(("org.nickharle"))      // JPA Entity scan

public class SpringBootApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder application) {
        return application.sources(SpringBootApp.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringBootApp.class, args);
    }


}
