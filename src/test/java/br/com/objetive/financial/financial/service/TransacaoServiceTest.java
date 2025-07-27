package br.com.objetive.financial.financial.service;

import br.com.objetive.financial.usecase.transationorder.adapter.external.dto.TransacaoRequestDTO;
import br.com.objetive.financial.common.exception.BussinessExceptionErro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransacaoServiceTest {
    @InjectMocks
    private TransacaoService service;


    @Test
    @DisplayName("Teste para validar que não será gerado uma tansacao.")
    public void naoDeveCriarContaComSaldoZerado(){
        BussinessExceptionErro result= null;
        String msg = "Erro: Numero conta está vazio.";
        try {
            service.criarTransacaoConta(TransacaoRequestDTO.builder().nmConta("").valor(0.0f).build());
        }catch (BussinessExceptionErro ex){
            result = ex;
        }
        Assertions.assertNotNull(result);
        Assertions.assertEquals(msg,result.getMessage());
    }




}
