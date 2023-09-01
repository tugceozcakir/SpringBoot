package com.tugceozcakir.healthtourismproject.model.requestDTO;

import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AvailabilityRequestDTO extends BaseDTO {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}
