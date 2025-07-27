package br.com.objetive.financial.usecase.bankaccount.converter;

import br.com.objetive.financial.usecase.bankaccount.adapter.external.dto.BankAccountDTO;
import br.com.objetive.financial.usecase.bankaccount.model.BankAccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {

    BankAccountMapper INSTANCE = Mappers.getMapper(BankAccountMapper.class);

    @Mapping(source = "model.accountNumber", target = "numeroConta")
    @Mapping(source = "model.balance", target = "saldo")
    BankAccountDTO toDTO(BankAccountModel model);

}
