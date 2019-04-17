package fr.isilis.infra;

import fr.isilis.infra.service.ActorGeneratorService;
import fr.isilis.infra.service.AllGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReportingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportingServiceApplication.class, args);
    }

    @Bean
    @Autowired
    public CommandLineRunner  commandLineRunner(AllGeneratorService allGeneratorService){
        return args -> {
          allGeneratorService.generate();
        };
    }


    @Bean
    @Autowired
    public CommandLineRunner  commandLineRunner2(ActorGeneratorService actorGeneratorService){
        return args -> {
            actorGeneratorService.generate();
        };
    }
}
