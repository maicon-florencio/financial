package br.com.objetive.financial.usecase.operationtransation.port;

import br.com.objetive.financial.usecase.operationtransation.entity.OperationTransation;

public interface OperationTransationOutputPort {
    OperationTransation save(OperationTransation operationTransation);
}
