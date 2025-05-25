package invoiceCreator.backend.strategy.service.Impl;


import invoiceCreator.backend.common.CurrencyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StrategyManager {

    private final CurrencyConversionStrategyImpl conversionStrategy;

    @Autowired
    public StrategyManager(CurrencyConversionStrategyImpl conversionStrategy) {
        this.conversionStrategy = conversionStrategy;
    }

    public BigDecimal convert(BigDecimal amount , CurrencyCode targetCurrency) {

        return conversionStrategy.convert(amount, targetCurrency);
    }
}
