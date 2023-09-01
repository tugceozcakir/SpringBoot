package com.tugceozcakir.healthtourismproject.model;

import com.tugceozcakir.healthtourismproject.database.entity.AvailabilityEntity;
import com.tugceozcakir.healthtourismproject.database.entity.HotelEntity;
import com.tugceozcakir.healthtourismproject.database.entity.ReservationEntity;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RoomDTO extends BaseDTO {
    //private HotelEntity hotelEntity;
    private String roomType;
    private BigDecimal price;
    private List<AvailabilityDTO> checkInTime;
}
