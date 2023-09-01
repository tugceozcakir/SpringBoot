package com.tugceozcakir.healthtourismproject.controller;

import com.tugceozcakir.healthtourismproject.database.entity.ReportEntity;
import com.tugceozcakir.healthtourismproject.database.repository.ReportRepository;
import com.tugceozcakir.healthtourismproject.database.specification.ReportSpecification;
import com.tugceozcakir.healthtourismproject.mapper.ReportMapper;
import com.tugceozcakir.healthtourismproject.model.ReportDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.ReportRequestDTO;
import com.tugceozcakir.healthtourismproject.service.ReportService;
import com.tugceozcakir.healthtourismproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController extends BaseController<
        ReportEntity,
        ReportDTO,
        ReportRequestDTO,
        ReportMapper,
        ReportRepository,
        ReportSpecification,
        ReportService> {

    @Autowired
    ReportService reportService;

    @Override
    protected ReportService getService() {
        return reportService;
    }
}
