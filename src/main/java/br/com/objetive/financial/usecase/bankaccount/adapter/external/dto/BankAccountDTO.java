package br.com.objetive.financial.usecase.bankaccount.adapter.external.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountDTO implements Serializable {
    private String numeroConta;
    private Float saldo;
}
