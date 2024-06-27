package br.com.objetive.financial.financial.domain.service.order;

import br.com.objetive.financial.financial.domain.dto.TransacaoDTO;
import br.com.objetive.financial.financial.domain.dto.enumeration.TipoTransacaoEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DebitTransationDataService extends AbstractTransationDataService{
    @Override
    public TipoTransacaoEnum getTransationType() {
        return TipoTransacaoEnum.DEBITO;
    }

    @Override
    public void process(TransacaoDTO transacaoDTO) {

    }
}
