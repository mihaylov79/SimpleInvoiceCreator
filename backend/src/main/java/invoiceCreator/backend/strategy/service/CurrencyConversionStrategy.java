package invoiceCreator.backend.strategy.service;

import java.math.BigDecimal;

public interface CurrencyConversionStrategy {

    BigDecimal converter(BigDecimal amount , BigDecimal baseCurrency, BigDecimal strategyCurrency );

    String getCurrencyCode();
}
