package com.example.salesproject.model.requestDTO;

import com.example.salesproject.model.SortDTO;
import com.example.salesproject.util.SearchCriteria;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}
