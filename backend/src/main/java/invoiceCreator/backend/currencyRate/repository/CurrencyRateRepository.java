package invoiceCreator.backend.currencyRate.repository;

import invoiceCreator.backend.common.CurrencyCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface CurrencyRateRepository extends JpaRepository<CurrencyCode, BigDecimal> {
}
