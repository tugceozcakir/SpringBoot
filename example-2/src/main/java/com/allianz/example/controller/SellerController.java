package com.allianz.example.controller;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.service.SellerService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/seller")
public class SellerController extends BaseController<SellerDTO, SellerEntity, SellerRequestDTO, SellerService> {
    @Autowired
    private SellerService sellerService;
    @Override
    protected SellerService getBaseService(){
        return sellerService;
    }
}
