package invoiceCreator.backend.currencyRate.repository;

import invoiceCreator.backend.common.CurrencyCode;
import invoiceCreator.backend.currencyRate.model.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, UUID> {
    Optional<CurrencyRate> findByBaseCurrencyAndTargetCurrency(CurrencyCode baseCurrency, CurrencyCode targetCurrency);
}
