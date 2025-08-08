package br.com.objetive.financial.usecase.bankaccount.service.factory;

import br.com.objetive.financial.usecase.bankaccount.enumeration.TypeOperationTransationEnum;

public interface ITransationDataService {

    TypeOperationTransationEnum getTransationType();
    Float process(Float valorEnviado, Float saldoConta);
}
