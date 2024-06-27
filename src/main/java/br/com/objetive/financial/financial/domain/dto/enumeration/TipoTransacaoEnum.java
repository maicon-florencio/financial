package br.com.objetive.financial.financial.domain.dto.enumeration;

public enum TipoTransacaoEnum {
    DEBITO("CARTão DEBITO","D"),
    CREDITO("CARTão CREDITO", "C"),
    PIX("CARTão CREDITO","P");

    private String desc;
    private String value;

    TipoTransacaoEnum(String desc, String valor){
        this.desc =desc;
        this.desc = valor;
    }
}
