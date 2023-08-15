package com.example.salesproject.model.requestDTO;

import com.example.salesproject.model.SortDTO;
import lombok.Data;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
}
