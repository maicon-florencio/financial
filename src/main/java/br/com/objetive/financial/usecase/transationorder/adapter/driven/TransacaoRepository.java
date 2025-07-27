package br.com.objetive.financial.usecase.transationorder.adapter.driven;

import br.com.objetive.financial.usecase.transationorder.entity.OperationTransation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<OperationTransation,Long> {
}
