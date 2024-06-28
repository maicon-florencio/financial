package br.com.objetive.financial.financial.rest;

import br.com.objetive.financial.financial.domain.dto.BankAccountDTO;
import br.com.objetive.financial.financial.service.BankAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@Tag(name = "conta", description = "Service Conta")
@RequestMapping("/api/v1/conta")
public class BankAccountController {
    @Autowired
    private  BankAccountService service;
    @PostMapping
    public ResponseEntity<BankAccountDTO> criarConta(@Validated @RequestBody BankAccountDTO dto){
        return new ResponseEntity<>(service.criarConta(dto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Busca bank acount por numero conta",
            description = "Busca conta via query param nmConta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "not found operation"),
            @ApiResponse(responseCode = "400", description = "BadRequest operation")
    })
    @GetMapping()
    public ResponseEntity<BankAccountDTO> buscaPorNmConta(@RequestParam("numero")  String nmConta){
        return new ResponseEntity<>(service.buscarContaPorNumeroConta(nmConta), HttpStatus.OK);
    }

}
