package br.com.objetive.financial.financial.domain.dto;

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
