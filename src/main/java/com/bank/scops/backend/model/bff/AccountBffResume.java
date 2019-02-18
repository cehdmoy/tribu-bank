package com.bank.scops.backend.model.bff;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AccountBffResume
{
    private String descripcion;

    private String accountId;

    private String saldo;


}