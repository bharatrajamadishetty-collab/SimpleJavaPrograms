import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WordsInStringManipulations {
        static String reverseChararactersInEachWord(String a) {
                return Stream.of(a.split("\\s+")).map(w -> new StringBuffer().append(w).reverse())
                                .collect(Collectors.joining(" "));
        }

        static String reverseCharsInEachWord(String a) {
                return Stream.of(a.split("\\s+")).map(word -> Stream.of(word.split(""))
                                .reduce("", (x, y) -> y + x))
                                .collect(Collectors.joining(" "));
        }

        static String wordsInReverseSequenceOrder(String b) {
                return Stream.of(b.split("\\s+")).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                        Collections.reverse(list);
                        return String.join(" ", list);
                }));
        }

        static String wordsInReverseSequenceUsingIntStream(String b) {
                String[] t = b.split("\\s+");
                return IntStream.range(0, t.length).mapToObj(j -> t[t.length - 1 - j]).collect(Collectors.joining(" "));
        }

        static String reverseWordsAndCharacters(String c) {
                String g = Stream.of(c.split("\\s+")).map(z -> new StringBuilder(z).reverse())
                                .collect(Collectors.joining(" "));
                String[] h = g.split("\\s+");
                return IntStream.range(0, h.length).mapToObj(k -> h[h.length - 1 - k]).collect(Collectors.joining(" "));
        }

        static String reverseWordsAndChars(String d) {
                return Stream.of(d.split("\\s+")).map(word -> Stream.of(word.split(""))
                                .reduce("", (x, y) -> y + x)).reduce("", (x, y) -> y + " " + x);
        }

        public static void main(String[] args) {
                String s = "I am a      software developer.";
                Optional<String> secondLargest = Arrays.stream(s.replaceAll("[^a-zA-Z\\s]", "").split("\\s+"))
                                .sorted(Comparator.comparingInt(String::length).reversed()).skip(1).findFirst();
                secondLargest.ifPresent(word -> System.out.println("Second Largest word : " + word));

                Optional<Integer> second = Arrays.stream(s.split("[^a-zA-Z\\\\s+]")).map(i -> i.length())
                                .sorted(Comparator.reverseOrder()).skip(1).findFirst();
                second.ifPresent(length -> System.out.println("Length of second largest word : " + length));

                Optional<String> first = Arrays.stream(s.split("[^a-zA-Z\\\\s+]"))
                                .sorted(Comparator.comparingInt(String::length).reversed()).findFirst();
                first.ifPresent(length -> System.out.println("Largest word : " + length));

                String t = Stream.of(s.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+"))
                                .max(Comparator.comparing(String::length))
                                .orElse("");
                System.out.println("Largest word : " + t);

                Optional<Integer> max = Arrays.stream(s.split("[^a-zA-Z\\\\s+]")).map(i -> i.length())
                                .max(Comparator.naturalOrder());
                max.ifPresent(length -> System.out.println("Length of largest word : " + length));

                System.out.println(
                                "Printing all reversed characters in each word : " + reverseChararactersInEachWord(s));
                System.out.println(
                                "Printing all reversed characters in each word : " + reverseCharsInEachWord(s));
                System.out.println("Printing all words in reverse sequence order : " + wordsInReverseSequenceOrder(s));
                System.out.println("Printing all words in reverse sequence order : "
                                + wordsInReverseSequenceUsingIntStream(s));
                System.out.println("Printing all words in reverse sequence order with all characters also reversed : "
                                + reverseWordsAndCharacters(s));
                System.out.println("Printing all words in reverse sequence order with all characters also reversed : "
                                + reverseWordsAndChars(s));

        }

}
