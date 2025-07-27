package br.com.objetive.financial.usecase.operationtransation.adapter.external.controller;

import br.com.objetive.financial.usecase.operationtransation.service.TransacaoService;
import br.com.objetive.financial.usecase.operationtransation.adapter.external.dto.OperationTransationRequest;
import br.com.objetive.financial.usecase.operationtransation.adapter.external.dto.OperationTransationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/transacao")
public class TransacaoController {
    @Autowired
    private TransacaoService service;

    @PostMapping
    public ResponseEntity<OperationTransationResponse> criarTransacaoBancaria(@RequestBody OperationTransationRequest dto){
       return new ResponseEntity<>(service.criarTransacaoConta(dto), HttpStatus.CREATED);
    }
}
