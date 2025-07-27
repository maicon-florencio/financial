package br.com.objetive.financial.usecase.bankaccount.enumeration;

import java.util.Arrays;
import java.util.Objects;

public enum TypeOperationTransationEnum {
    DEBITO("D"), CREDITO("C"), PIX("P");

    private String value;

    TypeOperationTransationEnum(String valor) {
        this.value = valor;
    }

    public static TypeOperationTransationEnum getTypeOperationTransationEnumByValuer(String val) {
        return Arrays.stream(TypeOperationTransationEnum.values()).filter(tp -> Objects.nonNull(val) && (tp.value.equals(val.toUpperCase()))).findFirst().orElseThrow(() -> new IllegalArgumentException("No type operation with value: " + val));
    }

}
