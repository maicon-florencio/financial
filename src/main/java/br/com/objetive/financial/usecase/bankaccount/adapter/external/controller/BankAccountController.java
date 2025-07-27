package br.com.objetive.financial.usecase.bankaccount.adapter.external.controller;

import br.com.objetive.financial.usecase.bankaccount.adapter.external.dto.BankAccountDTO;
import br.com.objetive.financial.usecase.bankaccount.converter.BankAccountMapper;
import br.com.objetive.financial.usecase.bankaccount.model.BankAccountModel;
import br.com.objetive.financial.usecase.bankaccount.port.BankAccountInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@Tag(name = "conta", description = "Service Conta")
@RequestMapping("/api/v1/conta")
public class BankAccountController {

    private final BankAccountInputPort bankAccountInputPort;

    public BankAccountController(BankAccountInputPort bankAccountInputPort) {
        this.bankAccountInputPort = bankAccountInputPort;
    }

    @Operation(
            summary = "Create a bank account.",
            description = "Create a bank account.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "not found operation"),
            @ApiResponse(responseCode = "400", description = "BadRequest operation"),
            @ApiResponse(responseCode = "422", description = "Bussiness operation")
    })
    @PostMapping
    public ResponseEntity<BankAccountDTO> createAccount(@Validated @RequestBody BankAccountDTO dto) {
        var bankAccountRequest = BankAccountModel.builder()
                .accountNumber(dto.getNumeroConta())
                .balance(dto.getSaldo())
                .build();
        var bankAccount = bankAccountInputPort.createAccount(bankAccountRequest);
        return new ResponseEntity<>(BankAccountMapper.INSTANCE.toDTO(bankAccount), HttpStatus.CREATED);
    }

    @Operation(
            summary = "find bank account by bank account number.",
            description = "find bank account to use query paramn with number account.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "not found operation"),
            @ApiResponse(responseCode = "400", description = "BadRequest operation")
    })
    @GetMapping()
    public ResponseEntity<BankAccountDTO> findByNumberAccount(@RequestParam("numberAccount") String numberAccount) {
        var bankAccountModel = bankAccountInputPort.findAccountByAccountNumber(numberAccount);

        return new ResponseEntity<>(BankAccountMapper.INSTANCE.toDTO(bankAccountModel), HttpStatus.OK);
    }

}
