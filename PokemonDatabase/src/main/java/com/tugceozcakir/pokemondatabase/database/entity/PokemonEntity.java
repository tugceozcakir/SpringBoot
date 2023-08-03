package com.tugceozcakir.pokemondatabase.database.entity;

import com.tugceozcakir.pokemondatabase.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pokemon")
@AttributeOverride(name = "uuid", column = @Column(name = "pokemon_uuid"))
@Data
public class PokemonEntity extends BaseEntity {
    @Column
    private String name;

    @Column
    private String type;

    @Column
    private int health;

    @Column
    private int damage;
}
