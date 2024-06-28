package br.com.objetive.financial.financial.domain.dto.enumeration;

import java.util.Arrays;
import java.util.Objects;

public enum TipoTransacaoEnum {
    DEBITO("CARTão DEBITO","D"),
    CREDITO("CARTão CREDITO", "C"),
    PIX("CARTão CREDITO","P");

    private String desc;
    private String value;

    TipoTransacaoEnum(String desc, String valor){
        this.desc =desc;
        this.value = valor;
    }

    public static TipoTransacaoEnum getTipoTransacaoEnumByValor(String val){
        return  Arrays.stream(TipoTransacaoEnum.values())
                .filter(tp -> Objects.nonNull(val) && (tp.value.equals(val.toUpperCase())))
                .findFirst().orElse(null);
    }

}
