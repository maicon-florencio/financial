package br.com.objetive.financial.usecase.operationtransation.service;

import br.com.objetive.financial.usecase.bankaccount.port.BankAccountInputPort;
import br.com.objetive.financial.usecase.operationtransation.adapter.external.dto.OperationTransationResponse;
import br.com.objetive.financial.usecase.operationtransation.model.OperationTransationModel;
import br.com.objetive.financial.usecase.operationtransation.port.OperationTransationInputPort;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService implements OperationTransationInputPort {

    private final BankAccountInputPort bankAccountInputPort;

    public TransacaoService(BankAccountInputPort bankAccountInputPort) {
        this.bankAccountInputPort = bankAccountInputPort;
    }


    @Override
    public OperationTransationModel createTransation(OperationTransationModel model) {
        bankAccountInputPort.updateBankAccountByOperationTransation(model.getNumberAccount(), model.getBalance(), model.getPaymentsForm());
        return new OperationTransationModel();
    }
}
