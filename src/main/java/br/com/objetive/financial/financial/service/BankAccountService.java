package br.com.objetive.financial.financial.service;

import br.com.objetive.financial.financial.domain.BankAccount;
import br.com.objetive.financial.financial.domain.dto.BankAccountDTO;
import br.com.objetive.financial.financial.exception.BussinessExceptionErro;
import br.com.objetive.financial.financial.mapper.BankAccountMapper;
import br.com.objetive.financial.financial.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository repository;


    public BankAccountDTO criarConta(BankAccountDTO dto) {
        if(dto.getNumeroConta().isEmpty()) throw new BussinessExceptionErro("Erro: NmConta não pode ser vazio.");
        if(dto.getSaldo() == 0.0) throw new BussinessExceptionErro("Erro: Valor do saldo não pode ser 0.");
        if(Objects.nonNull(buscarBanckAccountPorNmConta(dto))){ throw  new BussinessExceptionErro("Erro: Conta existente!");}
        BankAccount contaSalva = save(BankAccountMapper.INSTANCE.toEntity(dto));
        return BankAccountMapper.INSTANCE.toDTO(contaSalva);
    }

    private BankAccount buscarBanckAccountPorNmConta(BankAccountDTO dto) {
      return repository.getBankAccountByNumeroConta(dto.getNumeroConta());
    }

    public BankAccountDTO buscarContaPorNumeroConta(String nmConta){
        if(nmConta.isEmpty()) throw new BussinessExceptionErro("Erro: Numero conta está vazio.");

        return BankAccountDTO.builder().numeroConta("BUSCADO").build();
    }


    public Float buscarSaldoAtualPorConta(String nmConta) {
        return Float.valueOf(0);
    }

    private BankAccount save(BankAccount entity){
        return  repository.save(entity);
    }
}
