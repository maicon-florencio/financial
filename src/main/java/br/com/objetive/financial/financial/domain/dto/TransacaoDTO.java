package br.com.objetive.financial.financial.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransacaoDTO {
    private String nmConta;
    private Float saldo;
    private String formaPagamento;
}
