package br.com.objetive.financial.financial.service;

import br.com.objetive.financial.financial.domain.dto.TransacaoRequestDTO;
import br.com.objetive.financial.financial.domain.dto.TransacaoResponseDTO;
import br.com.objetive.financial.financial.domain.dto.enumeration.TipoTransacaoEnum;
import br.com.objetive.financial.financial.exception.BussinessExceptionErro;
import br.com.objetive.financial.financial.service.order.ITransationDataService;
import br.com.objetive.financial.financial.service.order.TransationDataServiceFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransacaoService {
    private BankAccountService bankAccountService;
    private TransationDataServiceFactory serviceFactory;

    public TransacaoResponseDTO criarTransacaoConta(TransacaoRequestDTO dto) {
        if(dto.getNmConta().isEmpty()) throw new BussinessExceptionErro("Erro: Numero conta está vazio.");
        Float saldoConta = verificarSaldoConta(dto);
        TransacaoResponseDTO trDTO = processTransacaoAnalize(dto, saldoConta);
        bankAccountService.atualizarBankAccountPorTransacao(trDTO.getNmConta(),trDTO.getSaldo());
        return trDTO;
    }

    private Float verificarSaldoConta(TransacaoRequestDTO dto){
        Float saldoAtual = bankAccountService.buscarSaldoAtualPorConta(dto.getNmConta());
        if(dto.getValor() > saldoAtual) throw new BussinessExceptionErro("Erro: Saldo na conta menor que valor solicitado" + dto.getNmConta().concat("."));
        return saldoAtual;
    }

    private TransacaoResponseDTO processTransacaoAnalize(TransacaoRequestDTO dto,  Float saldoConta){
        ITransationDataService service = serviceFactory.getTransationTypeProcess(TipoTransacaoEnum.getTipoTransacaoEnumByValor(dto.getFormaPagamento()));
       return service.process(dto,saldoConta);
    }

}
