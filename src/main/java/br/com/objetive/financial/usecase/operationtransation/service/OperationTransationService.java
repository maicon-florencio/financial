package br.com.objetive.financial.usecase.operationtransation.service;

import br.com.objetive.financial.usecase.bankaccount.port.BankAccountInputPort;
import br.com.objetive.financial.usecase.operationtransation.entity.OperationTransation;
import br.com.objetive.financial.usecase.operationtransation.enumeration.StatusOperationTransationEnum;
import br.com.objetive.financial.usecase.operationtransation.model.OperationTransationModel;
import br.com.objetive.financial.usecase.operationtransation.port.OperationTransationInputPort;
import br.com.objetive.financial.usecase.operationtransation.port.OperationTransationOutputPort;
import org.springframework.stereotype.Service;

@Service
public class OperationTransationService implements OperationTransationInputPort {

    private final BankAccountInputPort bankAccountInputPort;
    private final OperationTransationOutputPort operationTransationOutputPort;

    public OperationTransationService(BankAccountInputPort bankAccountInputPort, OperationTransationOutputPort operationTransationOutputPort) {
        this.bankAccountInputPort = bankAccountInputPort;
        this.operationTransationOutputPort = operationTransationOutputPort;
    }

    @Override
    public OperationTransationModel createTransation(OperationTransationModel model) {
        OperationTransation operationTransation;
        try {
            final var bankAccountModel = bankAccountInputPort.updateBankAccountByOperationTransation(model.getNumberAccount(), model.getBalance(), model.getPaymentsForm());

            operationTransation = OperationTransation.builder()
                    .payments(model.getPaymentsForm())
                    .balance(bankAccountModel.getBalance())
                    .numberAccount(model.getNumberAccount())
                    .status(StatusOperationTransationEnum.OK)
                    .build();

        } catch (Exception e) {
            operationTransation = OperationTransation.builder()
                    .balance(model.getBalance())
                    .payments(model.getPaymentsForm())
                    .numberAccount(model.getNumberAccount())
                    .status(StatusOperationTransationEnum.ERROR)
                    .build();
        }
        final var entity  = operationTransationOutputPort.save(operationTransation);
        return OperationTransationModel.builder()
                .id(entity.getId())
                .balance(entity.getBalance())
                .paymentsForm(entity.getPayments())
                .numberAccount(entity.getNumberAccount())
                .status(entity.getStatus())
                .dtCreated(entity.getDtCreated())
                .dtUpdated(entity.getDtUpdated())
                .build();
    }

}
