package com.tugceozcakir.healthtourismproject.model;

import com.tugceozcakir.healthtourismproject.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AvailabilityDTO extends BaseDTO {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}
