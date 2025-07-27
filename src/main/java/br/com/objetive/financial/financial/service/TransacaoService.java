package br.com.objetive.financial.financial.service;

import br.com.objetive.financial.usecase.transationorder.adapter.external.dto.TransacaoRequestDTO;
import br.com.objetive.financial.usecase.transationorder.adapter.external.dto.TransacaoResponseDTO;
import br.com.objetive.financial.usecase.transationorder.enumeration.TypeOperationTransationEnum;
import br.com.objetive.financial.common.exception.BussinessExceptionErro;
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
        Float novoSaldoAposCalculoPercentualTipoPagamento = saldoConta - processTransacaoAnalize(dto, saldoConta);
        bankAccountService.atualizarBankAccountPorTransacao(dto.getNmConta(),novoSaldoAposCalculoPercentualTipoPagamento);
        return TransacaoResponseDTO.builder().nmConta(dto.getNmConta()).saldo(novoSaldoAposCalculoPercentualTipoPagamento).build();
    }

    private Float verificarSaldoConta(TransacaoRequestDTO dto){
        Float saldoAtual = bankAccountService.buscarSaldoAtualPorConta(dto.getNmConta());
        if(dto.getValor() > saldoAtual) throw new BussinessExceptionErro("Erro: Saldo na conta menor que valor solicitado" + dto.getNmConta().concat("."));
        return saldoAtual;
    }

    private Float processTransacaoAnalize(TransacaoRequestDTO dto,  Float saldoConta){
        ITransationDataService service = serviceFactory.getTransationTypeProcess(TypeOperationTransationEnum.getTipoTransacaoEnumByValor(dto.getFormaPagamento()));
       return service.process(dto.getValor(),saldoConta);
    }

}
