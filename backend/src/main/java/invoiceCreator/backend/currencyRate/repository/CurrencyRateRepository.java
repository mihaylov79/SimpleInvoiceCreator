package invoiceCreator.backend.currencyRate.repository;

import invoiceCreator.backend.common.CurrencyCode;
import invoiceCreator.backend.currencyRate.model.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, UUID> {
    Optional<CurrencyRate> findByBaseCurrencyAndTargetCurrency(CurrencyCode baseCurrency, CurrencyCode targetCurrency);
}
