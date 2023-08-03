package com.tugceozcakir.pokemondatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PokemonDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonDatabaseApplication.class, args);
    }

}
