package com.tugceozcakir.healthtourismproject.service;

import com.tugceozcakir.healthtourismproject.database.entity.HotelEntity;
import com.tugceozcakir.healthtourismproject.database.repository.HospitalRepository;
import com.tugceozcakir.healthtourismproject.database.repository.HotelRepository;
import com.tugceozcakir.healthtourismproject.database.specification.HotelSpecification;
import com.tugceozcakir.healthtourismproject.mapper.HotelMapper;
import com.tugceozcakir.healthtourismproject.model.HotelDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.HotelRequestDTO;
import com.tugceozcakir.healthtourismproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends BaseService<
        HotelEntity,
        HotelDTO,
        HotelRequestDTO,
        HotelMapper,
        HotelRepository,
        HotelSpecification
        >{

    @Autowired
    HotelMapper hotelMapper;

    @Autowired
    HotelRepository hospitalRepository;

    @Autowired
    HotelSpecification hotelSpecification;

    @Override
    protected HotelMapper getMapper() {
        return hotelMapper;
    }

    @Override
    protected HotelRepository getRepository() {
        return hospitalRepository;
    }

    @Override
    protected HotelSpecification getSpecification() {
        return hotelSpecification;
    }
}
