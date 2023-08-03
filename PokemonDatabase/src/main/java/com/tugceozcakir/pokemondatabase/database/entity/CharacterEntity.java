package com.tugceozcakir.pokemondatabase.database.entity;

import com.tugceozcakir.pokemondatabase.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "character")
@AttributeOverride(name = "uuid", column = @Column(name = "character_uuid"))
@Data
public class CharacterEntity extends BaseEntity {
    @Column
    private String name;

    @Column
    private String specialPower;
}
