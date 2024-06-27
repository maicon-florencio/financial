package br.com.objetive.financial.financial.domain.rest;

import br.com.objetive.financial.financial.domain.dto.BankAccountDTO;
import br.com.objetive.financial.financial.domain.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/conta")
public class BankAccountController {
    @Autowired
    private  BankAccountService service;
    @PostMapping
    public ResponseEntity<BankAccountDTO> criarConta(@Validated @RequestBody BankAccountDTO dto){
        return new ResponseEntity<>(service.criarConta(dto), HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<BankAccountDTO> buscaPorNmConta(@RequestParam("numero")  String nmConta){
        return new ResponseEntity<>(service.buscarContaPorNumeroConta(nmConta), HttpStatus.OK);
    }

}
