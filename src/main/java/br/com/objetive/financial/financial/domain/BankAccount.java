package br.com.objetive.financial.financial.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount implements Serializable {

    private Long id;

    private String numeroConta;
    private Float saldo;

}
