package br.com.objetive.financial.financial.rest;

import br.com.objetive.financial.financial.domain.dto.TransacaoRequestDTO;
import br.com.objetive.financial.financial.domain.dto.TransacaoResponseDTO;
import br.com.objetive.financial.financial.service.TransacaoService;
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
    public ResponseEntity<TransacaoResponseDTO> criarTransacaoBancaria(@RequestBody TransacaoRequestDTO dto){
       return new ResponseEntity<>(service.criarTransacaoConta(dto), HttpStatus.CREATED);
    }
}
