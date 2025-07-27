package br.com.objetive.financial.usecase.operationtransation.adapter.external.dto;

import br.com.objetive.financial.usecase.bankaccount.enumeration.TypeOperationTransationEnum;
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
    private String accountNumber;
    @NotNull(message = "field required.")
    private Float balance;
    @NotNull(message = "field required.")
    private TypeOperationTransationEnum paymentsForm;

}
