package invoiceCreator.backend.item.model;

import invoiceCreator.backend.common.CurrencyCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column
    @Enumerated(EnumType.STRING)
    private CurrencyCode currency;

}
