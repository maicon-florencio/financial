package br.com.objetive.financial.usecase.operationtransation.service;

import br.com.objetive.financial.common.exception.BusinessException;
import br.com.objetive.financial.usecase.bankaccount.port.BankAccountInputPort;
import br.com.objetive.financial.usecase.operationtransation.adapter.external.dto.OperationTransationRequest;
import br.com.objetive.financial.usecase.operationtransation.adapter.external.dto.OperationTransationResponse;
import br.com.objetive.financial.usecase.operationtransation.enumeration.TypeOperationTransationEnum;
import br.com.objetive.financial.usecase.operationtransation.model.OperationTransationModel;
import br.com.objetive.financial.usecase.operationtransation.port.OperationTransationInputPort;
import br.com.objetive.financial.usecase.operationtransation.service.factory.TransationDataServiceFactory;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService implements OperationTransationInputPort {

    private final BankAccountInputPort bankAccountInputPort;
    private final TransationDataServiceFactory transationDataServiceFactory;

    public TransacaoService(BankAccountInputPort bankAccountInputPort, TransationDataServiceFactory serviceFactory) {
        this.bankAccountInputPort = bankAccountInputPort;
        this.transationDataServiceFactory = serviceFactory;
    }

    public OperationTransationResponse criarTransacaoConta(OperationTransationRequest dto) {
        Float saldoConta = verificarSaldoConta(dto);
        Float novoSaldoAposCalculoPercentualTipoPagamento = saldoConta - processTransacaoAnalize(dto, saldoConta);
        bankAccountService.atualizarBankAccountPorTransacao(dto.getNmConta(),novoSaldoAposCalculoPercentualTipoPagamento);
        return OperationTransationResponse.builder().nmConta(dto.getNmConta()).saldo(novoSaldoAposCalculoPercentualTipoPagamento).build();
    }

    private Float verificarSaldoConta(OperationTransationRequest dto){
        Float currentBalance = bankAccountInputPort.findAccountByAccountNumber(dto.getNmConta()).getBalance();
        if(dto.getValor() > currentBalance) throw new BusinessException("Saldo na conta menor que valor solicitado" + dto.getNmConta().concat("."));
        return currentBalance;
    }

    private Float processTransacaoAnalize(OperationTransationRequest dto, Float saldoConta) {
        return transationDataServiceFactory.getTransationTypeProcess(TypeOperationTransationEnum.getTipoTransacaoEnumByValor(dto.getFormaPagamento())).process(dto.getValor(), saldoConta);
    }

    @Override
    public OperationTransationModel createTransation(OperationTransationModel model) {
        Float saldoConta = verificarSaldoConta(dto);
        Float novoSaldoAposCalculoPercentualTipoPagamento = saldoConta - processTransacaoAnalize(dto, saldoConta);
        bankAccountService.atualizarBankAccountPorTransacao(dto.getNmConta(),novoSaldoAposCalculoPercentualTipoPagamento);
        OperationTransationResponse.builder().nmConta(dto.getNmConta()).saldo(novoSaldoAposCalculoPercentualTipoPagamento).build();
        return null;
    }
}
