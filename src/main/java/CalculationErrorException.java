public class CalculationErrorException extends Exception {
    public static final String CALCULATE_ERROR = "Calculate Error";
    public CalculationErrorException(){
        super(CALCULATE_ERROR);
    }
}
