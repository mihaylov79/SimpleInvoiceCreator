package invoiceCreator.backend.common.exceptions;

public class CompanyAlreadyExistException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "Тази фирма вече съществува в базата данни!";

    public CompanyAlreadyExistException() {
        super(DEFAULT_MESSAGE);
    }

    public CompanyAlreadyExistException(String message) {
        super(message);
    }
}
