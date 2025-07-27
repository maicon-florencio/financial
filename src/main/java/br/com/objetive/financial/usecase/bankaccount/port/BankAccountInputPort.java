package br.com.objetive.financial.usecase.bankaccount.port;

import br.com.objetive.financial.usecase.bankaccount.model.BankAccountModel;

public interface BankAccountInputPort {

    BankAccountModel createAccount( BankAccountModel bankAccountModel);
    BankAccountModel findAccountByAccountNumber(String numberAccount);
    void updateBankAccountByOperationTransation(String accountNumber, Float newBalanceUpdate);
}
