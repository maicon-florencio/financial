package br.com.objetive.financial.usecase.bankaccount.adapter.external.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountDTO implements Serializable {
    @NotNull(message = "required field.")
    private String numeroConta;
    @NotNull(message = "required field.")
    private Float saldo;
}
