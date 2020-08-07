package io.github.alishrf.travel_website;

import org.hashids.Hashids;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebSecurity
public class TravelWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelWebsiteApplication.class, args);
    }

}
