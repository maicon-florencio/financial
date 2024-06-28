package br.com.objetive.financial.financial.builder;

import br.com.objetive.financial.financial.domain.BankAccount;
import br.com.objetive.financial.financial.domain.dto.BankAccountDTO;

import java.util.Arrays;
import java.util.List;

public class BankAccountBuilder {

    public static BankAccount createEntity(boolean isEntityNull){
        return isEntityNull ? null :
                BankAccount.builder()
                        .id(1L)
                        .numeroConta("123456")
                        .saldo(1245.5f)
                        .build();
    }
    public static BankAccountDTO createBankDto(boolean isEntityNull){
        return isEntityNull ? null : BankAccountDTO.builder()
                .numeroConta("654321")
                .saldo(333.7f).build();
    }

    public static List<BankAccount> createEntityList(){
        return Arrays.asList(createEntity(false));
    }
    public static List<BankAccountDTO> createDtoList(){
        return Arrays.asList(createBankDto(false));
    }

}
