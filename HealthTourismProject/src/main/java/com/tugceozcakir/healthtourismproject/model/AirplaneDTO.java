package com.tugceozcakir.healthtourismproject.model;

import com.tugceozcakir.healthtourismproject.database.entity.AirlineCompanyEntity;
import com.tugceozcakir.healthtourismproject.database.entity.AvailabilityEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReservationEntity;
import com.tugceozcakir.healthtourismproject.model.enums.AirplaneClassName;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class AirplaneDTO extends BaseDTO {
    //private AirlineCompanyDTO airlineCompany;
    private String departureLocation;
    private String destination;
    private String departureDate;
    private int totalSeatingCapacity;
    private BigDecimal airplaneTicketPrice;
    private int emptySeatCount;
    private AirplaneClassName className;
    private List<AvailabilityDTO> flightTime;
}
