package br.com.objetive.financial.financial.service.order;

import br.com.objetive.financial.financial.domain.dto.enumeration.TipoTransacaoEnum;
import br.com.objetive.financial.financial.exception.BussinessExceptionErro;
import br.com.objetive.financial.financial.util.TransacaoUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PixTransationDataService extends AbstractTransationDataService{
    @Override
    public TipoTransacaoEnum getTransationType() {
        return TipoTransacaoEnum.PIX;
    }

    @Override
    public Float process(Float valor,Float saldoContaAtual) {
        Float valorComPercentualServico = TransacaoUtil.getValorComPercentualServico(valor,0.0f);
        if(valorComPercentualServico > saldoContaAtual )
            throw new BussinessExceptionErro(TransacaoUtil.ERRO_VALOR_MAIS_TAXA_MAIOR_SALDO);
        return valorComPercentualServico;
    }


}
