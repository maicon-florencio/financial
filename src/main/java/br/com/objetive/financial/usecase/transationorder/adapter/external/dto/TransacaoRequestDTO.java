package br.com.objetive.financial.usecase.transationorder.adapter.external.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoRequestDTO {

    private String nmConta;
    private Float valor;
    private String formaPagamento;

}
