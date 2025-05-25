package invoiceCreator.backend.strategy.service;

import invoiceCreator.backend.common.CurrencyCode;

import java.math.BigDecimal;

public interface CurrencyConversionStrategy {

    BigDecimal convert(BigDecimal amount , CurrencyCode targetCurrency );

//    String getCurrencyCode();
}
