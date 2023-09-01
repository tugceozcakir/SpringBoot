package com.tugceozcakir.healthtourismproject.controller;

import com.tugceozcakir.healthtourismproject.database.entity.HotelEntity;
import com.tugceozcakir.healthtourismproject.database.repository.HotelRepository;
import com.tugceozcakir.healthtourismproject.database.specification.HotelSpecification;
import com.tugceozcakir.healthtourismproject.mapper.HotelMapper;
import com.tugceozcakir.healthtourismproject.model.HotelDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.HotelRequestDTO;
import com.tugceozcakir.healthtourismproject.service.HotelService;
import com.tugceozcakir.healthtourismproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController extends BaseController<
        HotelEntity,
        HotelDTO,
        HotelRequestDTO,
        HotelMapper,
        HotelRepository,
        HotelSpecification,
        HotelService> {

    @Autowired
    HotelService hotelService;

    @Override
    protected HotelService getService() {
        return hotelService;
    }
}
