package br.com.objetive.financial.usecase.operationtransation.model;

import br.com.objetive.financial.usecase.bankaccount.enumeration.TypeOperationTransationEnum;
import br.com.objetive.financial.usecase.operationtransation.enumeration.StatusOperationTransationEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationTransationModel {
    private Long id;
    private String numberAccount;
    private Float balance;
    private TypeOperationTransationEnum paymentsForm;
    private StatusOperationTransationEnum status;

    private Instant dtCreated;
    private Instant dtUpdated;

}
