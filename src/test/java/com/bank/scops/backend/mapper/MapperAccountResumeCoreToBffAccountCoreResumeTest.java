package com.bank.scops.backend.mapper;

import com.bank.scops.backend.model.bff.AccountBffResume;
import com.bank.scops.backend.model.core.AccountCoreResume;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.bank.scops.backend.utils.TestHelper.buildCoreAccountResume;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MapperAccountResumeCoreToBffAccountCoreResumeTest {

    @InjectMocks
    private MapperAccountResumeCoreToBffAccountResume mapperAccountResumeCoreToBffAccountResume;

    @Mock
    private AmountFormatter amountFormatter;


    @Test
    public void checkAllFieldsPropagateTheRightValuesAfterMapFunctionHasBeenAiled() {
        when(amountFormatter.formatAmount(any())).thenReturn("$1.995.045");
        AccountCoreResume accountCoreResume = buildCoreAccountResume();
        AccountBffResume accountBffResume = mapperAccountResumeCoreToBffAccountResume.mapAccountBffResume(accountCoreResume);
        Assert.assertTrue("Is returning AccountBffResume data type", mapperAccountResumeCoreToBffAccountResume.mapAccountBffResume(accountCoreResume) instanceof AccountBffResume);
        Assert.assertNotNull("check account id is there", accountBffResume.getAccountId());
        Assert.assertEquals("check value for account id","972288268", accountBffResume.getAccountId());
        Assert.assertNotNull("check description is there", accountBffResume.getDescripcion());
        Assert.assertEquals("Check value for description","CUENTA-CORRIENTE", accountBffResume.getDescripcion());
        Assert.assertNotNull("check saldo is there", accountBffResume.getSaldo());
        Assert.assertEquals("check value for saldo ","$1.995.045", accountBffResume.getSaldo());

    }


}