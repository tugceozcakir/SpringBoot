package com.tugceozcakir.example.database.entity;

import com.tugceozcakir.example.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
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

    @Column(unique = true,length = 1250)
    private String name;

    @Column
    private String surname;

    @Column
    private int birthYear;

    @Column
    private String tc;


    @OneToMany(mappedBy = "person",fetch = FetchType.EAGER)
    private List<AddressEntity> addressEntityList;


}
