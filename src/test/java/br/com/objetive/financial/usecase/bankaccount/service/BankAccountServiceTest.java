package br.com.objetive.financial.usecase.bankaccount.service;

import br.com.objetive.financial.common.exception.BusinessException;
import br.com.objetive.financial.usecase.bankaccount.entity.BankAccount;
import br.com.objetive.financial.usecase.bankaccount.model.BankAccountModel;
import br.com.objetive.financial.usecase.bankaccount.port.BankAccountOutputPort;
import br.com.objetive.financial.usecase.bankaccount.service.factory.TransationDataServiceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class BankAccountServiceTest {

    @InjectMocks
    BankAccountService bankAccountService;

    @Mock
    BankAccountOutputPort bankAccountOutputPort;

    @Mock
    TransationDataServiceFactory transationDataServiceFactory;

    @Test
    void should_createExceptionExists() {
        var modelRequest = BankAccountModel.builder().accountNumber("123456").build();

        Mockito.when(bankAccountOutputPort.findAccountByAccountNumber(Mockito.any())).thenReturn(Optional.of(BankAccount.builder().id(1L).accountNumber("123456").balance(0.2F).build()));

        Assertions.assertThrows(BusinessException.class, () -> bankAccountService.createAccount(modelRequest));
    }
}
