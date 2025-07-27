package br.com.objetive.financial.usecase.bankaccount.adapter.driven;

import br.com.objetive.financial.usecase.bankaccount.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {
    Optional<BankAccount> getBankAccountByAccountNumber(String numberAccount);
}
