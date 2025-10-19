package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        final String input = Console.readLine();

        final Delimiter delimiter = Delimiter.from(input);
        final StringProcessor processor = new StringProcessor();
        final Calculator calculator = new Calculator();

        final String numbers = processor.extractNumbersPart(input);
        final CalculationResult calculationResult = calculator.calculate(numbers, delimiter);

        calculationResult.printResult();
    }


}