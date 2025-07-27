package br.com.objetive.financial.usecase.bankaccount.adapter.driven;

import br.com.objetive.financial.usecase.bankaccount.entity.BankAccount;
import br.com.objetive.financial.usecase.bankaccount.port.BankAccountOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BankAccountPersistenceAdapter implements BankAccountOutputPort {
    private final BankAccountRepository repository;

    public BankAccountPersistenceAdapter(BankAccountRepository repository) {
        this.repository = repository;
    }


    @Override
    public BankAccount createAccount(BankAccount bankAccount) {
        return repository.save(bankAccount);
    }

    @Override
    public Optional<BankAccount> findAccountByAccountNumber(String numberAccount) {
        return repository.getBankAccountByAccountNumber(numberAccount);
    }

}
