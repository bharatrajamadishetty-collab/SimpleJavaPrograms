import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

enum Category {
    UPPERCASE,
    LOWERCASE,
    DIGIT,
    OTHER
}

public class GroupCharsUsingCharacterFunctions {
    static Category getCategory(char c) {
        if (Character.isUpperCase(c))
            return Category.UPPERCASE;
        if (Character.isLowerCase(c))
            return Category.LOWERCASE;
        if (Character.isDigit(c))
            return Category.DIGIT;
        return Category.OTHER;
    }

    // using switch expression
    static Category groupingChars(char r) {
        return switch (Character.getType(r)) {
            case Character.UPPERCASE_LETTER -> Category.UPPERCASE;
            case Character.LOWERCASE_LETTER -> Category.LOWERCASE;
            case Character.DECIMAL_DIGIT_NUMBER -> Category.DIGIT;
            default -> Category.OTHER;
        };
    }

    public static void main(String[] args) {
        List<Character> chars = Arrays.asList(
                'A', 'b', '3', 'Z', 'x', '#', '7', 'm', '@');

        Map<Category, List<Character>> m = chars.stream().collect(Collectors.groupingBy(ch -> getCategory(ch)));
        System.out.println(m);

        Map<Category, List<Character>> n = chars.stream().collect(Collectors.groupingBy(ch -> groupingChars(ch)));
        System.out.println(n);

    }

}