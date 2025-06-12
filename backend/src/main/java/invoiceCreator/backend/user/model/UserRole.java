package invoiceCreator.backend.user.model;

public enum UserRole {
    GUEST("Гост"),
    USER("Служител"),
    MANAGER("Управител"),
    OWNER("Собственик"),
    ACCOUNTANT("Счетоводител"),
    ADMIN("Администратор");

    private String description;

    public String getDescription() {
        return description;
    }

    UserRole(String description){
        this.description = description;


    }
}
