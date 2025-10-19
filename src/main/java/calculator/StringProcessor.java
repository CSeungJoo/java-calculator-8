package calculator;

public class StringProcessor {

    public String extractNumbersPart(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            return input.substring(newlineIndex + 2);
        }
        return input;
    }
}
