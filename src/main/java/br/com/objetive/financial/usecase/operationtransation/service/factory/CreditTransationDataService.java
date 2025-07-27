package br.com.objetive.financial.usecase.operationtransation.service.factory;

import br.com.objetive.financial.usecase.operationtransation.enumeration.TypeOperationTransationEnum;
import br.com.objetive.financial.common.exception.BusinessException;
import br.com.objetive.financial.common.TransacaoUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CreditTransationDataService extends AbstractTransationDataService{
    @Override
    public TypeOperationTransationEnum getTransationType() {
        return TypeOperationTransationEnum.CREDITO;
    }

    @Override
    public Float process(Float valor, Float saldoContaAtual) {
        Float valorComPercentualServico = TransacaoUtil.getValorComPercentualServico(valor,5f);
        if(valorComPercentualServico > saldoContaAtual )
            throw new BusinessException(TransacaoUtil.ERRO_VALOR_MAIS_TAXA_MAIOR_SALDO);
        return valorComPercentualServico;
    }
}
