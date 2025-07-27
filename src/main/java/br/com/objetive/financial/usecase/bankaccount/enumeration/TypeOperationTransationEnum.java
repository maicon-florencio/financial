package br.com.objetive.financial.usecase.bankaccount.enumeration;

import java.util.Arrays;
import java.util.Objects;

public enum TypeOperationTransationEnum {
    DEBITO("CARTão DEBITO","D"),
    CREDITO("CARTão CREDITO", "C"),
    PIX("CARTão CREDITO","P");

    private String desc;
    private String value;

    TypeOperationTransationEnum(String desc, String valor){
        this.desc =desc;
        this.value = valor;
    }

    public static TypeOperationTransationEnum getTypeOperationTransationEnumByValuer(String val){
        return  Arrays.stream(TypeOperationTransationEnum.values())
                .filter(tp -> Objects.nonNull(val) && (tp.value.equals(val.toUpperCase())))
                .findFirst().orElse(null);
    }

}
