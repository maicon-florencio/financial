package br.com.objetive.financial.usecase.bankaccount.converter;

import br.com.objetive.financial.usecase.bankaccount.entity.BankAccount;
import br.com.objetive.financial.usecase.bankaccount.adapter.external.dto.BankAccountDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {

    BankAccountMapper INSTANCE = Mappers.getMapper(BankAccountMapper.class);

    BankAccountDTO toDTO(BankAccount entity);
    @InheritInverseConfiguration
    BankAccount toEntity(BankAccountDTO dto);

    List<BankAccountDTO> toDTOs(List<BankAccount> enties);
    List<BankAccount> toEntities(List<BankAccountDTO> dtos);

}
