package invoiceCreator.backend.config;

import invoiceCreator.backend.common.CurrencyCode;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    @Enumerated(EnumType.STRING)
    private CurrencyCode baseCurrency;

    public CurrencyCode getBaseCurrency(){
        return baseCurrency;
    }

    public void setBaseCurrency(CurrencyCode baseCurrency) {
        this.baseCurrency = baseCurrency;
    }
}
