package br.com.objetive.financial.usecase.operationtransation.adapter.external.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperationTransationResponse {
    private String nmConta;
    private Float saldo;

}
