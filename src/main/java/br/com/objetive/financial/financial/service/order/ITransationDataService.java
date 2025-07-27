package br.com.objetive.financial.financial.service.order;

import br.com.objetive.financial.usecase.transationorder.enumeration.TypeOperationTransationEnum;

public interface ITransationDataService {

    TypeOperationTransationEnum getTransationType();
    Float process(Float valorEnviado, Float saldoConta);
}
