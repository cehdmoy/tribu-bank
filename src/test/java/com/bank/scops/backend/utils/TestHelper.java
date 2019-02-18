package com.bank.scops.backend.utils;

import com.bank.scops.backend.model.core.AccountCoreResume;
import com.bank.scops.backend.model.core.Balance;
import com.bank.scops.backend.model.core.CurrAmount;
import com.bank.scops.backend.model.core.Product;

public class TestHelper {

    public static AccountCoreResume buildCoreAccountResume() {

        return AccountCoreResume.builder().accountId("972288268").balance(buildBalance()).product(buildProduct()).build();
    }

    private static Product buildProduct() {
        return Product.builder().productDesc("CUENTA-CORRIENTE").familyId("CTACTE").build();
    }

    private static Balance buildBalance() {
        return Balance.builder().currAmount(buildCurrentAmount()).build();
    }

    private static CurrAmount buildCurrentAmount() {
        return CurrAmount.builder().amount("").currency("").build();
    }
}
