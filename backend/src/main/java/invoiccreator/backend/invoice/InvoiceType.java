package invoiccreator.backend.invoice;

public enum InvoiceType {
    INVOICE("Фактура"),
    CREDIT_NOTE("Кредитно известие");

    private String description;

    InvoiceType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
