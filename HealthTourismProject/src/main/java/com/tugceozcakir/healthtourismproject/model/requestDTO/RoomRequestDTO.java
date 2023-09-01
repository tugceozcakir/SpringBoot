package com.tugceozcakir.healthtourismproject.model.requestDTO;

import com.tugceozcakir.healthtourismproject.database.entity.AvailabilityEntity;
import com.tugceozcakir.healthtourismproject.database.entity.HotelEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReservationEntity;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RoomRequestDTO extends BaseDTO {
    //private HotelEntity hotelEntity;
    private String roomType;
    private BigDecimal price;
    private List<AvailabilityRequestDTO> checkInTime;
}
