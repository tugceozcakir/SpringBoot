package com.example.salesproject.model;

import com.example.salesproject.model.enums.OrderStatusEnum;
import com.example.salesproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO extends BaseDTO {

    private CustomerDTO customer;
    private OrderStatusEnum orderStatus;
    private List<OrderItemDTO> orderItemList;
    private BigDecimal totalSellPrice;
}
