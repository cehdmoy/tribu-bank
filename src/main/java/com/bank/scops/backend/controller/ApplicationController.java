package com.bank.scops.backend.controller;

import com.bank.scops.backend.model.bff.AccountBffResume;
import com.bank.scops.backend.service.ApplicationOrchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    ApplicationOrchestrator applicationOrchestrator;

    @RequestMapping("/greeting")
    public List<AccountBffResume> greeting() {
        return applicationOrchestrator.retrieveAccountBffResume();
    }

}
