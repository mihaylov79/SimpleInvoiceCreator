package invoiceCreator.backend.currencyRate.model;

import invoiceCreator.backend.common.CurrencyCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "currency_rate")
public class CurrencyRate {

    @Id
    private CurrencyCode currencyCode;

    @Column
    private BigDecimal rateToEUR;
}
