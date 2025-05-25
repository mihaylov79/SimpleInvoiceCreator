package invoiceCreator.backend.currencyRate.model;

import invoiceCreator.backend.common.CurrencyCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "currency_rate")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "base_currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyCode baseCurrency;

    @Column(name = "target_currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyCode targetCurrency;

    @Column(nullable = false)
    private BigDecimal rate;
}
