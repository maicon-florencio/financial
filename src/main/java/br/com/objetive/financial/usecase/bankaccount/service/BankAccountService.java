package br.com.objetive.financial.usecase.bankaccount.service;

import br.com.objetive.financial.common.exception.BusinessException;
import br.com.objetive.financial.common.exception.NotFoundEntityException;
import br.com.objetive.financial.usecase.bankaccount.entity.BankAccount;
import br.com.objetive.financial.usecase.bankaccount.model.BankAccountModel;
import br.com.objetive.financial.usecase.bankaccount.port.BankAccountInputPort;
import br.com.objetive.financial.usecase.bankaccount.port.BankAccountOutputPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountService implements BankAccountInputPort {

    private final BankAccountOutputPort bankAccountOutputPort;

    public BankAccountService(BankAccountOutputPort bankAccountOutputPort) {
        this.bankAccountOutputPort = bankAccountOutputPort;
    }

    private BankAccount save(BankAccount entity) {
        return bankAccountOutputPort.createAccount(entity);
    }

    private Optional<BankAccount> findAccountByNmConta(String nmConta) {
        return bankAccountOutputPort.findAccountByAccountNumber(nmConta);
    }

    @Override
    public BankAccountModel createAccount(BankAccountModel bankAccountModel) {

        if (findAccountByNmConta(bankAccountModel.getAccountNumber()).isPresent()) {
            throw new BusinessException("Already exists.");
        }

        if (bankAccountModel.getBalance() == 0.0) throw new BusinessException("Balance cannot be zero.");

        BankAccount account = save(BankAccount.builder()
                .accountNumber(bankAccountModel.getAccountNumber())
                .balance(bankAccountModel.getBalance())
                .build());
        return new BankAccountModel(account.getId(), account.getAccountNumber(), account.getBalance());
    }

    @Override
    public BankAccountModel findAccountByAccountNumber(String numberAccount) {
        var bankAccount = findAccountByNmConta(numberAccount).orElseThrow(() -> new NotFoundEntityException("not found account."));
        return new BankAccountModel(bankAccount.getId(), bankAccount.getAccountNumber(), bankAccount.getBalance());
    }


    @Override
    public void updateBankAccountByOperationTransation(String accountNumber, Float newBalanceUpdate) {
        var bankAccount = findAccountByNmConta(accountNumber).orElseThrow(() -> new NotFoundEntityException("not found account."));

        if (newBalanceUpdate <= 0.0) throw new BusinessException("Balance cannot be zero.");

        save(bankAccount);
    }
}
