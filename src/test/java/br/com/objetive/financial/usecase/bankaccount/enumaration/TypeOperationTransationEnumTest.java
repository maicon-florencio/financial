package br.com.objetive.financial.usecase.bankaccount.enumaration;

import br.com.objetive.financial.usecase.bankaccount.enumeration.TypeOperationTransationEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TypeOperationTransationEnumTest {


    @Test
    void should_returnTypeOperationTransationEnum() {
        Assertions.assertEquals(TypeOperationTransationEnum.PIX,TypeOperationTransationEnum.getTypeOperationTransationEnumByValuer("P") );
        Assertions.assertEquals(TypeOperationTransationEnum.CREDITO,TypeOperationTransationEnum.getTypeOperationTransationEnumByValuer("C") );
        Assertions.assertEquals(TypeOperationTransationEnum.DEBITO,TypeOperationTransationEnum.getTypeOperationTransationEnumByValuer("D") );
    }

    @Test
    void should_returnIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TypeOperationTransationEnum.getTypeOperationTransationEnumByValuer("DOC"));
    }
}
