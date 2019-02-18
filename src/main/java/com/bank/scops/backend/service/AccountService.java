package com.bank.scops.backend.service;

import com.bank.scops.backend.gateway.AccountCoreGateway;
import com.bank.scops.backend.mapper.MapperAccountResumeCoreToBffAccountResume;
import com.bank.scops.backend.model.bff.AccountBffResume;
import com.bank.scops.backend.model.core.AccountCoreResume;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private AccountCoreGateway accountCoreGateway;

    private MapperAccountResumeCoreToBffAccountResume mapperAccountResumeCoreToBffAccountResume;

    public AccountService(AccountCoreGateway accountCoreGateway, MapperAccountResumeCoreToBffAccountResume mapperAccountResumeCoreToBffAccountResume) {
        this.accountCoreGateway = accountCoreGateway;
        this.mapperAccountResumeCoreToBffAccountResume = mapperAccountResumeCoreToBffAccountResume;
    }

    public List<AccountBffResume> retrieveAccountBffResume()
    {
        List<AccountCoreResume> accountCoreResumes = accountCoreGateway.retrieveAccountData();
        return buildAccountBFF(accountCoreResumes);
    }

    private List<AccountBffResume> buildAccountBFF(List<AccountCoreResume> accountCoreResumes) {
       return accountCoreResumes
               .stream()
               .map(accountCoreResume -> mapperAccountResumeCoreToBffAccountResume.mapAccountBffResume(accountCoreResume))
               .collect(Collectors.toList());
    }

}
