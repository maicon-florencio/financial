package br.com.objetive.financial.usecase.operationtransation.enumeration;

public enum StatusOperationTransationEnum {

    OK("okay"),
    ERROR("error");

    private String value;

    StatusOperationTransationEnum(String value){
        this.value = value;
    }

}
