package com.bank.scops.backend.mapper;

import org.springframework.stereotype.Service;

@Service
public class AmountFormatter {
    public String formatAmount(String amount) {

        int length = amount.length();
        if (length > 3) {
            return handleFormatAmount(amount, length);
        } else
            return "$" + amount;
    }

    private String handleFormatAmount(String amount, int length) {
        int endIndex = length - 3;
        String substringHeader = amount.substring(0, endIndex);
        String substringCola = amount.substring(endIndex);
        if (substringHeader.length() <= 3)
            return "$" + substringHeader + "." + substringCola;
        else
            return handleFormatAmount(substringHeader + "." + substringCola, substringHeader.length());
    }
}
