package com.tugceozcakir.healthtourismproject.database.entity;

import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "availability")
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "availability_uuid"
        )
)
public class AvailabilityEntity extends BaseEntity {
    @Column
    private LocalDate date;

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime endTime;

}
