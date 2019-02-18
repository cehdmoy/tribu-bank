package com.bank.scops.backend.controller;

import com.bank.scops.backend.model.bff.AccountBffResume;
import com.bank.scops.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/account")
    public List<AccountBffResume> account() {

        return accountService.retrieveAccountBffResume();
    }

}
