package br.com.objetive.financial.usecase.operationtransation.port;

import br.com.objetive.financial.usecase.operationtransation.model.OperationTransationModel;

public interface OperationTransationInputPort {
    OperationTransationModel createTransation(OperationTransationModel model);
}
