package invoiceCreator.backend.common;

public enum CurrencyCode {
    EUR ("€"),
    BGN ("лв"),
    USD ("$");

    private String symbol;

    CurrencyCode(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
