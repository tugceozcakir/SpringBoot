package com.tugceozcakir.healthtourismproject.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "room")
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "room_uuid"
        )
)
public class RoomEntity extends BaseEntity {
    @Column
    private String roomType;

    @Column
    private BigDecimal price;

    @OneToMany
    private List<AvailabilityEntity> checkInTime;
}
