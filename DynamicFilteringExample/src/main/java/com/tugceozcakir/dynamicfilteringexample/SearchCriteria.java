package com.tugceozcakir.dynamicfilteringexample;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}
