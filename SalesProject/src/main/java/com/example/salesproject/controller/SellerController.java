package com.example.salesproject.controller;

import com.example.salesproject.database.entity.SellerEntity;
import com.example.salesproject.database.repository.SellerRepository;
import com.example.salesproject.database.specification.SellerSpecification;
import com.example.salesproject.mapper.SellerMapper;
import com.example.salesproject.model.SellerDTO;
import com.example.salesproject.model.requestDTO.SellerRequestDTO;
import com.example.salesproject.service.SellerService;
import com.example.salesproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seller")
public class SellerController extends BaseController<
        SellerEntity,
        SellerDTO,
        SellerRequestDTO,
        SellerMapper,
        SellerRepository,
        SellerSpecification,
        SellerService> {

    @Autowired
    SellerService sellerService;

    @Override
    protected SellerService getService() {
        return this.sellerService;
    }
}
