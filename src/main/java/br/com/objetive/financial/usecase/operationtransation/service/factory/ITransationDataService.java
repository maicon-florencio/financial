package br.com.objetive.financial.usecase.operationtransation.service.factory;

import br.com.objetive.financial.usecase.operationtransation.enumeration.TypeOperationTransationEnum;

public interface ITransationDataService {

    TypeOperationTransationEnum getTransationType();
    Float process(Float valorEnviado, Float saldoConta);
}
