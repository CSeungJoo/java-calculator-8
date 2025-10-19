package calculator;

import java.math.BigDecimal;

public class NumberValidator {
    public static void validate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("음수나 0은 허용되지 않습니다: " + number);
        }
    }

    public static void validate(BigDecimal number) {
        if (number.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("음수나 0은 허용되지 않습니다: " + number);
        }
    }
}
