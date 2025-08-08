package br.com.objetive.financial.usecase.bankaccount.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountModel {

    private Long id;
    private String accountNumber;
    private Float balance;
}
