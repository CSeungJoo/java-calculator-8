package calculator;

import java.math.BigDecimal;

public class CalculationResult {
    private final BigDecimal value;

    private CalculationResult(BigDecimal value) {
        this.value = value;
    }

    public static CalculationResult of(BigDecimal value) {
        return new CalculationResult(value);
    }

    public void printResult() {
        System.out.println("결과 : " + value);
    }
}
