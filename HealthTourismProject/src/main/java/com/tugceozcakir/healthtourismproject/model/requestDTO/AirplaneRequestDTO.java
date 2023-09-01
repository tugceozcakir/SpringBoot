package com.tugceozcakir.healthtourismproject.model.requestDTO;

import com.tugceozcakir.healthtourismproject.database.entity.AirlineCompanyEntity;
import com.tugceozcakir.healthtourismproject.database.entity.AvailabilityEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReservationEntity;
import com.tugceozcakir.healthtourismproject.model.enums.AirplaneClassName;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class AirplaneRequestDTO extends BaseDTO {
    //private AirlineCompanyEntity airlineCompany;
    private String departureLocation;
    private String destination;
    private String departureDate;
    private int totalSeatingCapacity;
    private int emptySeatCount;
    private BigDecimal airplaneTicketPrice;
    private AirplaneClassName className;
    private List<AvailabilityRequestDTO> flightTime;
}
