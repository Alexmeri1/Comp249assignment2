public class MinimumWageException extends RuntimeException {

    public MinimumWageException(String message) {
        super(message);
    }

    public MinimumWageException(){
        super("Minimum wage not respected, should be at least 15.75$ ");
    }

}
