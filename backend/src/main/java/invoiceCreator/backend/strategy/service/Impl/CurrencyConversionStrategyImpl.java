package invoiceCreator.backend.strategy.service.Impl;

import invoiceCreator.backend.common.CurrencyCode;
import invoiceCreator.backend.config.AppProperties;
import invoiceCreator.backend.currencyRate.model.CurrencyRate;
import invoiceCreator.backend.currencyRate.repository.CurrencyRateRepository;
import invoiceCreator.backend.strategy.service.CurrencyConversionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CurrencyConversionStrategyImpl implements CurrencyConversionStrategy {

    private final CurrencyRateRepository rateRepository;
    private final AppProperties appProperties;

    @Autowired
    public CurrencyConversionStrategyImpl(CurrencyRateRepository rateRepository, AppProperties appProperties) {
        this.rateRepository = rateRepository;
        this.appProperties = appProperties;
    }



    @Override
    public BigDecimal converter(BigDecimal amount, CurrencyCode targetCurrency) {

        CurrencyCode base = appProperties.getBaseCurrency();

        if (targetCurrency == base) {
            return amount;
        }



        return null;
    }
}
