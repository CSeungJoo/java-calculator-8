package calculator;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiter {

    private final List<String> delimiters;

    private Delimiter() {
        this.delimiters = List.of(",", ":");
    }

    private Delimiter(List<String> delimiters) {
        this.delimiters = delimiters;
    }

    public static Delimiter from(String input) {
        if (!input.startsWith("//")) {
            return new Delimiter();
        }

        int newlineIndex = input.indexOf("\\n");
        if (newlineIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }

        String customDelimiter = input.substring(2, newlineIndex);

        List<String> all = new ArrayList<>(List.of(",", ":"));
        all.add(customDelimiter);

        return new Delimiter(List.copyOf(all));
    }

    public String regex() {
        return delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
