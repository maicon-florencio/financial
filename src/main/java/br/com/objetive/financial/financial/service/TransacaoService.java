package br.com.objetive.financial.financial.service;

import br.com.objetive.financial.financial.domain.dto.TransacaoDTO;
import br.com.objetive.financial.financial.exception.BussinessExceptionErro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
    @Autowired
    private BankAccountService bankAccountService;

    public TransacaoDTO criarTransacaoConta(TransacaoDTO dto) {
        if(dto.getNmConta().isEmpty()) throw new BussinessExceptionErro("Erro: Numero conta está vazio.");
        verificarSaldoConta(dto);

        return null;
    }

    private void verificarSaldoConta(TransacaoDTO dto){
        Float saldoAtual = bankAccountService.buscarSaldoAtualPorConta(dto.getNmConta());
        if(dto.getSaldo() < saldoAtual) throw new BussinessExceptionErro("Erro: Saldo na conta " + dto.getNmConta().concat("."));
    }
}
