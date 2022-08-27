package pl.kosmala.customer;

public class FraudsterFoundException
        extends RuntimeException {

    private String message;

    public FraudsterFoundException() {}

    public FraudsterFoundException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}