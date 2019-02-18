package com.bank.scops.backend.controller;

import com.bank.scops.backend.model.bff.AccountBffResume;
import com.bank.scops.backend.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/account")
    public List<AccountBffResume> account() {
        return accountService.retrieveAccountBffResume();
    }

}
