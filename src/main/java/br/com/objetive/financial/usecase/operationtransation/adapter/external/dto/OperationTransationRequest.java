package br.com.objetive.financial.usecase.operationtransation.adapter.external.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationTransationRequest {

    @NotNull(message = "field required.")
    private String nmConta;
    @NotNull(message = "field required.")
    private Float valor;
    @NotNull(message = "field required.")
    private String formaPagamento;

}
