package br.com.objetive.financial.usecase.operationtransation.service.factory;

import br.com.objetive.financial.usecase.operationtransation.enumeration.TypeOperationTransationEnum;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class TransationDataServiceFactory {
    @Setter(value = AccessLevel.PUBLIC)
    public List<ITransationDataService> dataServices;

    private Map<TypeOperationTransationEnum,ITransationDataService> serviceCache;

    public TransationDataServiceFactory(List<ITransationDataService> dataServices,
                                        Map<TypeOperationTransationEnum,ITransationDataService> cache){
        super();
        this.dataServices = dataServices;
        this.serviceCache = cache;
    }

    @PostConstruct
    public void initServiceCache() {

        this.serviceCache = new EnumMap<>(TypeOperationTransationEnum.class);
        dataServices.forEach(service -> serviceCache.put(service.getTransationType(),service));

    }

    public ITransationDataService getTransationTypeProcess(TypeOperationTransationEnum dataType){
        ITransationDataService service = serviceCache.get(dataType);
        if (service ==null){
            throw new RuntimeException("Tipo de transação não encontrada");
        }
        return service;
    }

}
