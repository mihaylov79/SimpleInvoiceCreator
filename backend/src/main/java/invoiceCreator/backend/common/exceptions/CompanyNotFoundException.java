package invoiceCreator.backend.common.exceptions;

public class CompanyNotFoundException extends RuntimeException {

private final static String DEFAULT_MESSAGE = "Търсената от Вас фирма не беше открита";

    public CompanyNotFoundException() {

        super(DEFAULT_MESSAGE);
    }

    public CompanyNotFoundException(String message) {
        super(message);
    }
}
