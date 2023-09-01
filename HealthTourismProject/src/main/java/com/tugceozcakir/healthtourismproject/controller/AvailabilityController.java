package com.tugceozcakir.healthtourismproject.controller;

import com.tugceozcakir.healthtourismproject.database.entity.AvailabilityEntity;
import com.tugceozcakir.healthtourismproject.database.repository.AvailabilityRepository;
import com.tugceozcakir.healthtourismproject.database.specification.AvailabilitySpecification;
import com.tugceozcakir.healthtourismproject.mapper.AvailabilityMapper;
import com.tugceozcakir.healthtourismproject.model.AvailabilityDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.AvailabilityRequestDTO;
import com.tugceozcakir.healthtourismproject.service.AvailabilityService;
import com.tugceozcakir.healthtourismproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/availability")
public class AvailabilityController extends BaseController<
        AvailabilityEntity,
        AvailabilityDTO,
        AvailabilityRequestDTO,
        AvailabilityMapper,
        AvailabilityRepository,
        AvailabilitySpecification,
        AvailabilityService> {

    @Autowired
    AvailabilityService availabilityService;

    @Override
    protected AvailabilityService getService() {
        return availabilityService;
    }
}
