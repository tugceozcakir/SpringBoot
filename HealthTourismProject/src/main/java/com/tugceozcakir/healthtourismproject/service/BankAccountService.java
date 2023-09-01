package com.tugceozcakir.healthtourismproject.service;

import com.tugceozcakir.healthtourismproject.database.entity.BankAccountEntity;
import com.tugceozcakir.healthtourismproject.database.repository.BankAccountRepository;
import com.tugceozcakir.healthtourismproject.database.specification.BankAccountSpecification;
import com.tugceozcakir.healthtourismproject.mapper.BankAccountMapper;
import com.tugceozcakir.healthtourismproject.model.BankAccountDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.BankAccountRequestDTO;
import com.tugceozcakir.healthtourismproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService extends BaseService<
        BankAccountEntity,
        BankAccountDTO,
        BankAccountRequestDTO,
        BankAccountMapper,
        BankAccountRepository,
        BankAccountSpecification> {

    @Autowired
    BankAccountMapper bankAccountMapper;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    BankAccountSpecification bankAccountSpecification;

    @Override
    protected BankAccountMapper getMapper() {
        return bankAccountMapper;
    }

    @Override
    protected BankAccountRepository getRepository() {
        return bankAccountRepository;
    }

    @Override
    protected BankAccountSpecification getSpecification() {
        return bankAccountSpecification;
    }
}
