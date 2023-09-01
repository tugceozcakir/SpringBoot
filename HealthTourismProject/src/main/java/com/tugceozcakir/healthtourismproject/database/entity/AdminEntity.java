package com.tugceozcakir.healthtourismproject.database.entity;

import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "admin")
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "address_uuid"
        )
)
public class AdminEntity extends BaseEntity {
    @Column
    private String email;

    @Column
    private String password;
}
