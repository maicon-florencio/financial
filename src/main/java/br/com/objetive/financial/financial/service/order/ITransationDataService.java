package br.com.objetive.financial.financial.service.order;

import br.com.objetive.financial.financial.domain.dto.TransacaoRequestDTO;
import br.com.objetive.financial.financial.domain.dto.TransacaoResponseDTO;
import br.com.objetive.financial.financial.domain.dto.enumeration.TipoTransacaoEnum;

public interface ITransationDataService {

    TipoTransacaoEnum getTransationType();
    TransacaoResponseDTO process(TransacaoRequestDTO dto, Float saldoConta);
}
