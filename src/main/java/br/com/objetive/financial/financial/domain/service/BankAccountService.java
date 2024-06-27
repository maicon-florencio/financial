package br.com.objetive.financial.financial.domain.service;

import br.com.objetive.financial.financial.domain.dto.BankAccountDTO;
import br.com.objetive.financial.financial.exception.BussinessExceptionErro;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {


    public BankAccountDTO criarConta(BankAccountDTO dto) {
        if(dto.getNumeroConta().isEmpty()) throw new BussinessExceptionErro("Erro: NmConta não pode ser vazio.");
        if(dto.getSaldo() == 0.0) throw new BussinessExceptionErro("Erro: Valor do saldo não pode ser 0.");
        //if(repository.findByNumeroConta(dto.getNumeroConta()))
        return BankAccountDTO.builder().numeroConta("Criado").build();
    }

    public BankAccountDTO buscarContaPorNumeroConta(String nmConta){
        if(nmConta.isEmpty()) throw new BussinessExceptionErro("Erro: Numero conta está vazio.");
        return BankAccountDTO.builder().numeroConta("BUSCADO").build();
    }


    public Float buscarSaldoAtualPorConta(String nmConta) {
        return Float.valueOf(0);
    }
}
