package com.example.salesproject.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class BaseDTO {

    @JsonIgnore
    private Long id;
    @JsonIgnore
    private UUID uuid;
    @JsonIgnore
    private Date creationDate;
    @JsonIgnore
    private Date updatedDate;


}
