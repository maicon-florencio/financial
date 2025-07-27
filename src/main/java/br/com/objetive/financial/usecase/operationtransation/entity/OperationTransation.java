package br.com.objetive.financial.usecase.operationtransation.entity;

import br.com.objetive.financial.usecase.bankaccount.enumeration.TypeOperationTransationEnum;
import br.com.objetive.financial.usecase.operationtransation.enumeration.StatusOperationTransationEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "operation_transation")
public class OperationTransation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberAccount;
    private Float balance;
    private TypeOperationTransationEnum payments;
    private StatusOperationTransationEnum status;

    @CreationTimestamp
    private Instant dtCreated;

    @UpdateTimestamp
    private Instant dtUpdated;
}
