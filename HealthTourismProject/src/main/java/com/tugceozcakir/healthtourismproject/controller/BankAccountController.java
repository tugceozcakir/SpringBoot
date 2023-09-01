package com.tugceozcakir.healthtourismproject.controller;

import com.tugceozcakir.healthtourismproject.database.entity.BankAccountEntity;
import com.tugceozcakir.healthtourismproject.database.repository.BankAccountRepository;
import com.tugceozcakir.healthtourismproject.database.specification.BankAccountSpecification;
import com.tugceozcakir.healthtourismproject.mapper.BankAccountMapper;
import com.tugceozcakir.healthtourismproject.model.BankAccountDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.BankAccountRequestDTO;
import com.tugceozcakir.healthtourismproject.service.BankAccountService;
import com.tugceozcakir.healthtourismproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bank-account")
public class BankAccountController extends BaseController<
        BankAccountEntity,
        BankAccountDTO,
        BankAccountRequestDTO,
        BankAccountMapper,
        BankAccountRepository,
        BankAccountSpecification,
        BankAccountService>
{

    @Autowired
    BankAccountService bankAccountService;

    @Override
    protected BankAccountService getService() {
        return bankAccountService;
    }
}
