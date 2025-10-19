package calculator;

public class CalculationResult {
    private final int value;

    private CalculationResult(int value) {
        this.value = value;
    }

    public static CalculationResult of(int value) {
        return new CalculationResult(value);
    }

    public void printResult() {
        System.out.println("결과 : " + value);
    }
}
