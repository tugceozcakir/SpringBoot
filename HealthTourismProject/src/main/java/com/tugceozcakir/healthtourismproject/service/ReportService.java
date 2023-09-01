package com.tugceozcakir.healthtourismproject.service;

import com.tugceozcakir.healthtourismproject.database.entity.ReportEntity;
import com.tugceozcakir.healthtourismproject.database.repository.ReportRepository;
import com.tugceozcakir.healthtourismproject.database.specification.ReportSpecification;
import com.tugceozcakir.healthtourismproject.mapper.ReportMapper;
import com.tugceozcakir.healthtourismproject.model.ReportDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.ReportRequestDTO;
import com.tugceozcakir.healthtourismproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService extends BaseService<
        ReportEntity,
        ReportDTO,
        ReportRequestDTO,
        ReportMapper,
        ReportRepository,
        ReportSpecification
        > {

    @Autowired
    ReportMapper reportMapper;

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    ReportSpecification reportSpecification;

    @Override
    protected ReportMapper getMapper() {
        return reportMapper;
    }

    @Override
    protected ReportRepository getRepository() {
        return reportRepository;
    }

    @Override
    protected ReportSpecification getSpecification() {
        return reportSpecification;
    }
}
