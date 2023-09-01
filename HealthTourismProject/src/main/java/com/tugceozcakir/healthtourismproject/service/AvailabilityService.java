package com.tugceozcakir.healthtourismproject.service;

import com.tugceozcakir.healthtourismproject.database.entity.AvailabilityEntity;
import com.tugceozcakir.healthtourismproject.database.repository.AvailabilityRepository;
import com.tugceozcakir.healthtourismproject.database.specification.AvailabilitySpecification;
import com.tugceozcakir.healthtourismproject.mapper.AvailabilityMapper;
import com.tugceozcakir.healthtourismproject.model.AvailabilityDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.AvailabilityRequestDTO;
import com.tugceozcakir.healthtourismproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityService extends BaseService<
        AvailabilityEntity,
        AvailabilityDTO,
        AvailabilityRequestDTO,
        AvailabilityMapper,
        AvailabilityRepository,
        AvailabilitySpecification
        > {

    @Autowired
    AvailabilityMapper availabilityMapper;

    @Autowired
    AvailabilityRepository availabilityRepository;

    @Autowired
    AvailabilitySpecification availabilitySpecification;

    @Override
    protected AvailabilityMapper getMapper() {
        return availabilityMapper;
    }

    @Override
    protected AvailabilityRepository getRepository() {
        return availabilityRepository;
    }

    @Override
    protected AvailabilitySpecification getSpecification() {
        return availabilitySpecification;
    }
}
