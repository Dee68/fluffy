public class InsufficientFundsException extends Exception{
    private String msg;

    public InsufficientFundsException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return String.format( "InsufficientFundsException: " + msg);
    }
}
