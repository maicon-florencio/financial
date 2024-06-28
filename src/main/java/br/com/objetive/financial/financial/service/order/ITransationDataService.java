package br.com.objetive.financial.financial.service.order;

import br.com.objetive.financial.financial.domain.dto.TransacaoDTO;
import br.com.objetive.financial.financial.domain.dto.enumeration.TipoTransacaoEnum;

public interface ITransationDataService {

    TipoTransacaoEnum getTransationType();
    TransacaoDTO process(TransacaoDTO transacaoDTO);
}
