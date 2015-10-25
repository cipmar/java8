import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by mariusrop on 16.10.2015.
 */
public class Example03 {
    public static void main(String[] args) {
        Stream<String> strings = Stream.of("one", "two", "3", "four", "V", "VI", "seven", "8", "IX", "zece");   // static methods in interfaces!

        Predicate<String> p1 = s -> s.length() > 3;
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("zece");

        strings
                .filter(p2.or(p3).and(p1))                                                                      // chaining predicates!
                .forEach(s -> System.out.println(s));
    }
}
