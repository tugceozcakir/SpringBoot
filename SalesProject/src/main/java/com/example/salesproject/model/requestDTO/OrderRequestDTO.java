package com.example.salesproject.model.requestDTO;

import com.example.salesproject.model.enums.OrderStatusEnum;
import com.example.salesproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequestDTO extends BaseDTO {

    private CustomerRequestDTO customer;
    private OrderStatusEnum orderStatus;
    private List<OrderItemRequestDTO> orderItemList;
    private BigDecimal totalSellPrice;
}