package br.com.objetive.financial.financial.util;
public class TransacaoUtil {

    public static String ERRO_VALOR_MAIS_TAXA_MAIOR_SALDO = "Valor não pode ser solicitado pois ao adicionar taxa de servico ultrapassa o saldo!";

    public static Float getValorComPercentualServico(Float valorSolicitado, Float percentualServico){
        Float result = valorSolicitado;
        if( percentualServico != 0.0f) {
            result += ( valorSolicitado * percentualServico) /100 ;
        }
        return result;
    }
}
