package com.tugceozcakir.pokemondatabase.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pokemon {
    private String name;
    private String type;
    private int health;
    private int damage;
}
