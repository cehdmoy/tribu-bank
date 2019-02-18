package com.bank.scops.backend.model.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter

public class Balance
{
    private CurrAmount currAmount;


}
