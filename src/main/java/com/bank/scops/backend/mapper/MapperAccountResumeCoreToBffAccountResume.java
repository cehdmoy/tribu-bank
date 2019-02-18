package com.bank.scops.backend.mapper;

import com.bank.scops.backend.model.bff.AccountBffResume;
import com.bank.scops.backend.model.core.AccountCoreResume;
import org.springframework.stereotype.Service;

@Service
public class MapperAccountResumeCoreToBffAccountResume {

    private AmountFormatter amountFormatter;


    public MapperAccountResumeCoreToBffAccountResume(AmountFormatter amountFormatter) {
        this.amountFormatter = amountFormatter;
    }

    public AccountBffResume mapAccountBffResume(AccountCoreResume accountCoreResume) {
        return AccountBffResume.builder()
                .accountId(accountCoreResume.getAccountId())
                .descripcion(accountCoreResume.getProduct().getProductDesc())
                .saldo(amountFormatter.formatAmount(accountCoreResume.getBalance().getCurrAmount().getAmount()))
                .build();
    }
}
