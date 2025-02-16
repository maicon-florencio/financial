package br.com.objetive.financial.financial.service;

import br.com.objetive.financial.financial.domain.BankAccount;
import br.com.objetive.financial.financial.domain.dto.BankAccountDTO;
import br.com.objetive.financial.financial.exception.BussinessExceptionErro;
import br.com.objetive.financial.financial.exception.NotFoundEntityException;
import br.com.objetive.financial.financial.mapper.BankAccountMapper;
import br.com.objetive.financial.financial.repository.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Transactional
public class BankAccountService {

    private final BankAccountRepository repository;

    public BankAccountService(BankAccountRepository repository) {
        this.repository = repository;
    }


    public BankAccountDTO criarConta(BankAccountDTO dto) {
        if(dto.getNumeroConta().isEmpty()) throw new BussinessExceptionErro("Erro: NmConta não pode ser vazio.");
        if(dto.getSaldo() == 0.0) throw new BussinessExceptionErro("Erro: Valor do saldo não pode ser 0.");
        if(Objects.nonNull(findAccountByNmConta(dto.getNumeroConta()).getNumeroConta())){ throw  new BussinessExceptionErro("Erro: Conta existente!");}
        BankAccount contaSalva = save(BankAccountMapper.INSTANCE.toEntity(dto));
        return BankAccountMapper.INSTANCE.toDTO(contaSalva);
    }

    public BankAccountDTO buscarContaPorNumeroConta(String nmConta){
        if(nmConta.isEmpty()) throw new BussinessExceptionErro("Erro: Numero conta está vazio.");
        return BankAccountMapper.INSTANCE.toDTO(findAccountByNmConta(nmConta));
    }


    public Float buscarSaldoAtualPorConta(String nmConta) {
        BankAccount bankAccount = findAccountByNmConta(nmConta);
        if(Objects.isNull(bankAccount)) throw new NotFoundEntityException("Conta não encontrada");
        return bankAccount.getSaldo();
    }
    public void atualizarBankAccountPorTransacao(String nmConta, Float saldoAAtualizar){
        BankAccount byNmConta = findAccountByNmConta(nmConta);
        if(byNmConta != null){
            byNmConta.setSaldo(saldoAAtualizar);
            save(byNmConta);
        }
    }

    private BankAccount save(BankAccount entity){
        return  repository.save(entity);
    }

    private BankAccount findAccountByNmConta(String nmConta) {
        return repository.getBankAccountByNumeroConta(nmConta);
    }
}
