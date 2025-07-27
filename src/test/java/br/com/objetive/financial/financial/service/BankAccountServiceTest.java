package br.com.objetive.financial.financial.service;

import br.com.objetive.financial.financial.builder.BankAccountBuilder;
import br.com.objetive.financial.usecase.bankaccount.entity.BankAccount;
import br.com.objetive.financial.usecase.bankaccount.adapter.external.dto.BankAccountDTO;
import br.com.objetive.financial.common.exception.BussinessExceptionErro;
import br.com.objetive.financial.usecase.bankaccount.adapter.driven.BankAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class BankAccountServiceTest {
    @Autowired
    private BankAccountService service;
    @MockBean
    private BankAccountRepository repository;
    @Test
    @DisplayName("Teste para valdiar que não será salvo conta sem saldo")
    public void naoDeveCriarContaComSaldoZerado(){
        BussinessExceptionErro result= null;
        String msg = "Erro: Valor do saldo não pode ser 0.";
    try {
        service.criarConta(BankAccountDTO.builder().numeroConta("12345").saldo(0.0f).build());
    }catch (BussinessExceptionErro ex){
        result = ex;
    }
        Assertions.assertNotNull(result);
        Assertions.assertEquals(msg,result.getMessage());
    }

    @Test
    @DisplayName("Teste para valdiar que não será salvo conta sem nmConta")
    public void naoDeveCriarContaSemNmConta(){
        BussinessExceptionErro result= null;
        String msg = "Erro: NmConta não pode ser vazio.";
        try {
            service.criarConta(BankAccountDTO.builder().numeroConta("").saldo(145.85f).build());
        }catch (BussinessExceptionErro ex){
            result = ex;
        }
        Assertions.assertNotNull(result);
        Assertions.assertEquals(msg,result.getMessage());
    }

    @Test
    @DisplayName("Teste para validar erro ao buscar nmConta inexistente")
    public void deveBuscaContaVazio() {
        BussinessExceptionErro result= null;
        String msg = "Erro: Numero conta está vazio.";
        try {
            service.buscarContaPorNumeroConta("");
        }catch (BussinessExceptionErro ex){
             result = ex;
        }
        Assertions.assertNotNull(result);
        Assertions.assertEquals(msg,result.getMessage());

    }
    @Test
    public void deveCriarBankAccount(){
        BankAccount bankAccount = BankAccountBuilder.createEntity(false);
        Mockito.when(repository.save(Mockito.any())).thenReturn(bankAccount);

        BankAccountDTO result = service.criarConta(BankAccountDTO.builder().numeroConta("12345").saldo(1000f).build());
        Assertions.assertNotNull(result);
        Assertions.assertEquals(bankAccount.getSaldo(),result.getSaldo());

        Mockito.verify(repository, Mockito.times(1)).getBankAccountByNumeroConta(Mockito.anyString());
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());

    }

    @Test
    public void devoAtualizarSaldoConta(){
        BankAccount bankAccount = BankAccountBuilder.createEntity(false);
        Mockito.when(repository.getBankAccountByNumeroConta(Mockito.any())).thenReturn(bankAccount);

        service.atualizarBankAccountPorTransacao("123456", 500f);

        Mockito.verify(repository, Mockito.times(1)).getBankAccountByNumeroConta(Mockito.anyString());
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());

    }


}
