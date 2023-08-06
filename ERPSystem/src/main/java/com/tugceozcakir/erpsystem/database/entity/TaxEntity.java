package com.tugceozcakir.erpsystem.database.entity;

import com.tugceozcakir.erpsystem.util.dbutil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "tax")
@AttributeOverride(name = "uuid", column = @Column(name = "tax_uuid"))
@Data
public class TaxEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private double percent;
    public TaxEntity(){

    }
    public TaxEntity(String uuid) {
        this.setUuid(UUID.fromString(uuid));
    }
}


