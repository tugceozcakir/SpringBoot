package com.tugceozcakir.example.database.entity;

import com.tugceozcakir.example.util.dbutil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "person_uuid"
        )
)
@Data
public class PersonEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private int birthYear;

    @Column
    private String tc;


}