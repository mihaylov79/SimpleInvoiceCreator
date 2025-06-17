package invoiceCreator.backend.common.exceptions;

public class UsernameAlreadyExist extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Потребител с това потребителско име вече съществува!";

    public UsernameAlreadyExist() {
        super(DEFAULT_MESSAGE);
    }

    public UsernameAlreadyExist(String message) {
        super(message);
    }
}
