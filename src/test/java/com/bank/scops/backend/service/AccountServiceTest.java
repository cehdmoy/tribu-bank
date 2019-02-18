package com.bank.scops.backend.service;

import com.bank.scops.backend.gateway.AccountCoreGateway;
import com.bank.scops.backend.mapper.MapperAccountResumeCoreToBffAccountResume;
import com.bank.scops.backend.model.bff.AccountBffResume;
import com.bank.scops.backend.model.core.AccountCoreResume;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.bank.scops.backend.utils.TestHelper.buildCoreAccountResume;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountCoreGateway accountCoreGateway;

    @Mock
    private MapperAccountResumeCoreToBffAccountResume mapperAccountResumeCoreToBffAccountResume;

    @BeforeEach
    void setUp() {
        List<AccountCoreResume> accountCoreResumeList = buildCoreAccountResumeResponse();
        when(accountCoreGateway.retrieveData()).thenReturn(accountCoreResumeList);
        when(mapperAccountResumeCoreToBffAccountResume.mapAccountBffResume(any())).thenReturn(buildAccountBffResume());
    }

    @Test
    void checkFieldsAfterMapCoreDataToBff() {
        List<AccountBffResume> accountBffResumes = accountService.retrieveAccountBffResume();
        assertNotNull(accountBffResumes, "Response is not null");
        Assert.assertEquals("BBF account resume has one element",1,accountBffResumes.size());
    }

    private AccountBffResume buildAccountBffResume() {
        return AccountBffResume.builder().build();
    }

    private List<AccountCoreResume> buildCoreAccountResumeResponse() {
        List<AccountCoreResume> accountCoreResumeList = new ArrayList<>();
        accountCoreResumeList.add(buildCoreAccountResume());
        return accountCoreResumeList;
    }
}