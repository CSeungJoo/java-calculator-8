package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {

    private static List<String> delimiters = new ArrayList<>(
            List.of(",", ":")
    );

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        input = input.replace("\\n", "\n");

        String processedInput = processCustomDelimiter(input);

        int calculatedNumber = calculateExpression(processedInput);

        System.out.println("결과 : " + calculatedNumber);
    }

    public static int calculateExpression(String expression) {
        if (expression.isBlank()) {
            return 0;
        }

        String regex = delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        int sum = Arrays.stream(expression.split(regex))
                .mapToInt(Integer::parseInt)
                .sum();

        return sum;
    }

    private static String processCustomDelimiter(String expression) {
        if (expression.startsWith("//")) {
            int newlineIndex = expression.indexOf("\n");
            String customDelimiter = expression.substring(2, newlineIndex);
            delimiters.add(customDelimiter);
            return expression.substring(newlineIndex + 1);
        }
        return expression;
    }
}
