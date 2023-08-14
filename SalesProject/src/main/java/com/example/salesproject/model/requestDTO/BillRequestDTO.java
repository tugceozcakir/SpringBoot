package com.example.salesproject.model.requestDTO;

import com.example.salesproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BillRequestDTO extends BaseDTO {
    private String billNo;
    private LocalDateTime billDate;
    private BigDecimal taxRate;
    private BigDecimal taxAmount;
    private BigDecimal totalSellNetPrice;
    private BigDecimal totalSellPrice;
    private OrderRequestDTO order;
}
