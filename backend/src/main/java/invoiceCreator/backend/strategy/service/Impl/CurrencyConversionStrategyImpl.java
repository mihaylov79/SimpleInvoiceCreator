package invoiceCreator.backend.strategy.service.Impl;

import invoiceCreator.backend.strategy.service.CurrencyConversionStrategy;

import java.math.BigDecimal;

public class CurrencyConversionStrategyImpl implements CurrencyConversionStrategy {

    @Override
    public BigDecimal converter(BigDecimal amount, BigDecimal baseCurrency, BigDecimal strategyCurrency) {
        return null;
    }

    @Override
    public String getCurrencyCode() {
        return "";
    }
}
