package com.tugceozcakir.healthtourismproject.model.requestDTO;

import com.tugceozcakir.healthtourismproject.model.SortDTO;
import com.tugceozcakir.healthtourismproject.util.SearchCriteria;
import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;

}
