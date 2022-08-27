package pl.kosmala.customer;

public class CustomerAlreadyExistsInDatabaseException
        extends RuntimeException {

    private String message;

    public CustomerAlreadyExistsInDatabaseException() {}

    public CustomerAlreadyExistsInDatabaseException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
