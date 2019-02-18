package com.bank.scops.backend.gateway;


import com.bank.scops.backend.model.core.AccountCoreResume;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;

import java.util.List;



@ExtendWith(MockitoExtension.class)
class AccountCoreGatewayTest {

    @InjectMocks
    private AccountCoreGateway accountCoreGateway;

    @Mock
    private RestOperations gatewayRestTemplate;

    @BeforeEach
    void setUp() {

        accountCoreGateway = new AccountCoreGateway("",gatewayRestTemplate);
        AccountCoreResume[] accountCoreResumes = {AccountCoreResume.builder().accountId("someAccountId").build()};
        ResponseEntity<AccountCoreResume[]> responseEntity =  new ResponseEntity(accountCoreResumes, HttpStatus.OK);
        Mockito.when(gatewayRestTemplate.getForEntity(
                Mockito.anyString(),
                ArgumentMatchers.any(Class.class)
        )).thenReturn(responseEntity);
    }

    @Test
    void retrieveData() {
        List<AccountCoreResume> accountCoreResumeList = accountCoreGateway.retrieveAccountData();
        Assert.assertNotNull("Check response from rest template gateway is not null", accountCoreResumeList);
        Assert.assertEquals(1,accountCoreResumeList.size());
        Assert.assertEquals("someAccountId",accountCoreResumeList.get(0).getAccountId());
    }
}