package br.com.objetive.financial.usecase.operationtransation.adapter.driven;

import br.com.objetive.financial.usecase.operationtransation.entity.OperationTransation;
import br.com.objetive.financial.usecase.operationtransation.port.OperationTransationOutputPort;
import org.springframework.stereotype.Component;

@Component
public class OperationTransationPersistenceAdapter implements OperationTransationOutputPort {

    private final OperationTransationRepository operationTransationRepository;

    public OperationTransationPersistenceAdapter(OperationTransationRepository operationTransationRepository) {
        this.operationTransationRepository = operationTransationRepository;
    }

    @Override
    public OperationTransation save(OperationTransation operationTransation) {
        return operationTransationRepository.save(operationTransation);
    }
}
