package com.tugceozcakir.healthtourismproject.database.entity;

import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "airlineCompany")
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "airline_company_uuid"
        )
)
public class AirlineCompanyEntity extends BaseEntity {
    @Column
    private String companyName;

    @Column
    private String contactNumber;

    @OneToMany
    private List<AirplaneEntity> airplaneEntityList;
}
