package com.tugceozcakir.healthtourismproject.model.requestDTO;

import com.tugceozcakir.healthtourismproject.database.entity.RoomEntity;
import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class HotelRequestDTO extends BaseDTO {
    private String name;
    private String city;
    private String address;
    private String contactNumber;
    private List<RoomRequestDTO> roomList;
}
