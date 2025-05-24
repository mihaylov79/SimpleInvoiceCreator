package invoiccreator.backend.strategy.model;

import java.math.BigDecimal;

public interface CurrencyConversionStrategy {

    BigDecimal converter(BigDecimal amount , BigDecimal baseCurrency, BigDecimal strategyCurrency );

    String getCurrencyCode();
}
