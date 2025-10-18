package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {

    private static final List<String> delimiters = new ArrayList<>(List.of(",", ":"));

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String processedInput = processCustomDelimiter(input);

        int result = calculateExpression(processedInput);

        System.out.println("결과 : " + result);
    }

    private static int calculateExpression(String expression) {
        if (expression.isBlank()) {
            return 0;
        }

        String regex = delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        try {
            return Arrays.stream(expression.split(regex))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .peek(Application::validatePositive)
                    .sum();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.", e);
        }
    }

    private static String processCustomDelimiter(String expression) {
        if (expression.startsWith("//")) {
            int newlineIndex = expression.indexOf("\\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
            String customDelimiter = expression.substring(2, newlineIndex);
            delimiters.add(customDelimiter);
            return expression.substring(newlineIndex + 2);
        }
        return expression;
    }

    private static void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("음수나 0은 허용되지 않습니다: " + number);
        }
    }
}