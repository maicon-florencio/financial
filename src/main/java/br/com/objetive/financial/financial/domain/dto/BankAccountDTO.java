package br.com.objetive.financial.financial.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDTO implements Serializable {
    private String numeroConta;
    private Float saldo;

    private String usuario;
}
