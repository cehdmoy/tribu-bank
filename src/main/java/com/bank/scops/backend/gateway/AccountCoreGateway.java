package com.bank.scops.backend.gateway;

import com.bank.scops.backend.model.core.AccountCoreResume;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.util.Arrays;
import java.util.List;


@Service
public class AccountCoreGateway {

    private String urlAccountCoreResumeService;

    private RestOperations gatewayRestTemplate;


    public AccountCoreGateway(@Value("${core.account.resume.url}") String urlAccountCoreResumeService, RestOperations gatewayRestTemplate) {
        this.urlAccountCoreResumeService = urlAccountCoreResumeService;
        this.gatewayRestTemplate = gatewayRestTemplate;
    }

    public List<AccountCoreResume> retrieveData() {
        ResponseEntity<AccountCoreResume[]> forEntity = gatewayRestTemplate.getForEntity(urlAccountCoreResumeService, AccountCoreResume[].class);
        return Arrays.asList(forEntity.getBody());
    }

}
