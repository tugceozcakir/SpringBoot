package com.tugceozcakir.healthtourismproject.database.entity;

import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hotel")
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "hotel_uuid"
        )
)
public class HotelEntity extends BaseEntity {
    @Column
    private String name;

    @Column
    private String city;

    @Column
    private String address;

    @Column
    private String contactNumber;

    @OneToMany
    private List<RoomEntity> roomList;
}
