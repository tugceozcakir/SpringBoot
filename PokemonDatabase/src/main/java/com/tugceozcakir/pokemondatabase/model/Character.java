package com.tugceozcakir.pokemondatabase.model;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Character {
    private String name;
    private String specialPower;
}
