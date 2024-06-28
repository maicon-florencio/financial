package br.com.objetive.financial.financial.service.order;

import br.com.objetive.financial.financial.domain.dto.enumeration.TipoTransacaoEnum;
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

    private Map<TipoTransacaoEnum,ITransationDataService> serviceCache;

    public TransationDataServiceFactory(List<ITransationDataService> dataServices,
                                        Map<TipoTransacaoEnum ,ITransationDataService> cache){
        super();
        this.dataServices = dataServices;
        this.serviceCache = cache;
    }

    @PostConstruct
    public void initServiceCache() {

        this.serviceCache = new EnumMap<>(TipoTransacaoEnum.class);
        dataServices.forEach(service -> serviceCache.put(service.getTransationType(),service));

    }

    public ITransationDataService getTransationTypeProcess(TipoTransacaoEnum dataType){
        ITransationDataService service = serviceCache.get(dataType);
        if (service ==null){
            throw new RuntimeException("Tipo de transação não encontrada");
        }
        return service;
    }

}
