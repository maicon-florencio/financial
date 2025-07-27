package br.com.objetive.financial.usecase.operationtransation.adapter.external.controller;

import br.com.objetive.financial.usecase.operationtransation.adapter.external.dto.OperationTransationRequest;
import br.com.objetive.financial.usecase.operationtransation.model.OperationTransationModel;
import br.com.objetive.financial.usecase.operationtransation.port.OperationTransationInputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/operation-transation")
public class TransacaoController {
    private final OperationTransationInputPort operationTransationInputPort;

    public TransacaoController(OperationTransationInputPort operationTransationInputPort) {
        this.operationTransationInputPort = operationTransationInputPort;
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody OperationTransationRequest operationTransationRequest) {
        var model = OperationTransationModel.builder()
                .numberAccount(operationTransationRequest.getAccountNumber())
                .paymentsForm(operationTransationRequest.getPaymentsForm())
                .balance(operationTransationRequest.getBalance())
                .build();
        return new ResponseEntity<>(operationTransationInputPort.createTransation(model), HttpStatus.CREATED);
    }
}
