package br.com.objetive.financial.financial.domain.rest;

import br.com.objetive.financial.financial.domain.dto.TransacaoDTO;
import br.com.objetive.financial.financial.domain.service.TransacaoService;
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
    public ResponseEntity<TransacaoDTO> criarTransacaoBancaria(@RequestBody TransacaoDTO dto){
       return new ResponseEntity<>(service.criarTransacaoConta(dto), HttpStatus.CREATED);
    }
}
