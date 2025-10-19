package calculator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.Predicate;

public class Calculator {
    public CalculationResult calculate(String expression, Delimiter delimiter) {
        if (expression.isBlank()) {
            return CalculationResult.of(BigDecimal.ZERO);
        }

        String regex = delimiter.regex();
        String[] split = expression.split(regex);
        try {
            BigDecimal sum = Arrays.stream(split)
                    .map(String::trim)
                    .filter(Predicate.not(String::isEmpty))
                    .map(BigDecimal::new)
                    .peek(NumberValidator::validate)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            return CalculationResult.of(sum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.", e);
        }
    }
}