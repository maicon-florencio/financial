package br.com.objetive.financial.financial.service;

import br.com.objetive.financial.financial.domain.dto.BankAccountDTO;
import br.com.objetive.financial.financial.domain.service.BankAccountService;
import br.com.objetive.financial.financial.exception.BussinessExceptionErro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.zip.DataFormatException;

@SpringBootTest
public class BankAccountServiceTest {
    @InjectMocks
    private BankAccountService service;
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
    public void deveBuscaContaVazio() throws InstantiationException, IllegalAccessException {
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


}
