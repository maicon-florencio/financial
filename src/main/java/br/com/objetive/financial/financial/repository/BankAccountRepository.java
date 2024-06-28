package br.com.objetive.financial.financial.repository;

import br.com.objetive.financial.financial.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {


    BankAccount getBankAccountByNumeroConta(String nmConta);

}
