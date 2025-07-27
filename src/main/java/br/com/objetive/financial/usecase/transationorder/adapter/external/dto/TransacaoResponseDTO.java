package br.com.objetive.financial.usecase.transationorder.adapter.external.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransacaoResponseDTO {
    private String nmConta;
    private Float saldo;

}
