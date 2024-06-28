package br.com.objetive.financial.financial.domain.dto;

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
