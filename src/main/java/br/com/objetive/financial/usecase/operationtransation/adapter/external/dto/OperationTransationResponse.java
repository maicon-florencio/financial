package br.com.objetive.financial.usecase.operationtransation.adapter.external.dto;

import br.com.objetive.financial.usecase.operationtransation.enumeration.StatusOperationTransationEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperationTransationResponse {
    private String accountBankNumber;
    private Float balance;
    private StatusOperationTransationEnum status;
    private Instant dtCreated;
}
