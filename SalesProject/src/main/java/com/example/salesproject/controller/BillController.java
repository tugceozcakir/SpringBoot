package com.example.salesproject.controller;

import com.example.salesproject.database.entity.BillEntity;
import com.example.salesproject.database.repository.BillRepository;
import com.example.salesproject.mapper.BillMapper;
import com.example.salesproject.model.BillDTO;
import com.example.salesproject.model.requestDTO.BillRequestDTO;
import com.example.salesproject.service.BillService;
import com.example.salesproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController extends BaseController<
        BillEntity,
        BillDTO,
        BillRequestDTO,
        BillMapper,
        BillRepository,
        BillService> {

    @Autowired
    BillService billService;

    @Override
    protected BillService getService() {
        return billService;
    }
}
