package br.com.objetive.financial.usecase.bankaccount.port;

import br.com.objetive.financial.usecase.bankaccount.entity.BankAccount;

import java.util.Optional;

public interface BankAccountOutputPort {

    BankAccount createAccount(BankAccount bankAccount);
    Optional<BankAccount> findAccountByAccountNumber(String numberAccount);
}
