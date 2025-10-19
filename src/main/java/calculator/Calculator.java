package calculator;

import java.util.Arrays;

public class Calculator {
    public CalculationResult calculate(String expression, Delimiter delimiter) {
        if (expression.isBlank()) {
            return CalculationResult.of(0);
        }

        String regex = delimiter.regex();
        String[] split = expression.split(regex);
        try {
            int sum = Arrays.stream(split)
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .peek(NumberValidator::validate)
                    .sum();
            return CalculationResult.of(sum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.", e);
        }
    }
}