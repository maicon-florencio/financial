package br.com.objetive.financial.usecase.operationtransation.adapter.driven;

import br.com.objetive.financial.usecase.operationtransation.entity.OperationTransation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationTransationRepository extends JpaRepository<OperationTransation,Long> {
}
