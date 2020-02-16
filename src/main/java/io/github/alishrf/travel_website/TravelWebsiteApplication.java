package io.github.alishrf.travel_website;

import org.hashids.Hashids;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TravelWebsiteApplication {

    public static void main(String[] args) {
        Hashids hashids = new Hashids("saltttttttttttttttttttttttttttttttttttttt");
        System.out.println(hashids.encode(123,46 ,789,45566,1424,123,7841));
        SpringApplication.run(TravelWebsiteApplication.class, args);
    }

}
