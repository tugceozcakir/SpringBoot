package com.tugceozcakir.healthtourismproject.database.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tugceozcakir.healthtourismproject.model.enums.AirplaneClassName;
import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "airplane")
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "airplane_uuid"
        )
)
public class AirplaneEntity extends BaseEntity {
    @Column
    private String departureLocation;
    @Column
    private String destination;
    @Column
    private String departureDate;
    @Column
    private int totalSeatingCapacity;
    @Column
    private int emptySeatCount;
    @Enumerated(EnumType.STRING)
    private AirplaneClassName className;
    @OneToMany
    private List<AvailabilityEntity> flightTime;
    @Column
    private BigDecimal airplaneTicketPrice;

    // Update the number of empty seats
    public void makeReservation() {
        if (emptySeatCount > 0) {
            emptySeatCount--;

        } else {
            System.out.println("There are no empty seats.");
        }
    }

}
