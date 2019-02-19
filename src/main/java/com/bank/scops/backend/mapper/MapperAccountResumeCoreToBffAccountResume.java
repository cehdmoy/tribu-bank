package com.bank.scops.backend.mapper;

import com.bank.scops.backend.model.bff.AccountBffResume;
import com.bank.scops.backend.model.core.AccountCoreResume;
import com.bank.scops.backend.model.core.Balance;
import com.bank.scops.backend.model.core.CurrAmount;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
                .saldo(handleSaldoField(accountCoreResume))
                .build();
    }

    private String handleSaldoField(AccountCoreResume accountCoreResume) {
        AccountCoreResume accountCoreResumeToProcess = Optional.ofNullable(accountCoreResume).orElse(buildDefaultAccountCoreResponse());
        Balance balance = Optional.ofNullable(accountCoreResumeToProcess.getBalance()).orElse(buildDefaultBalance());
        CurrAmount currAmount = Optional.ofNullable(balance.getCurrAmount()).orElse(buildDefaultCurrentAmount());
        String amount = Optional.ofNullable(currAmount.getAmount()).orElse("0");
        return amountFormatter.formatAmount(amount);
    }

    private AccountCoreResume buildDefaultAccountCoreResponse() {
        return AccountCoreResume.builder().balance(buildDefaultBalance()).build();
    }

    private Balance buildDefaultBalance() {
        return Balance.builder().currAmount(buildDefaultCurrentAmount()).build();
    }

    private CurrAmount buildDefaultCurrentAmount() {
        return CurrAmount.builder().amount("0").build();
    }
}
