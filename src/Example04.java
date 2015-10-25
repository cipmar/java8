import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by mariusrop on 16.10.2015.
 */
public class Example04 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("one", "two", "3", "four", "V", "VI", "seven", "8", "IX", "zece");   // static methods in interfaces!
        Stream<String> stream2 = Stream.of("one", "two", "3", "four", "V", "VI", "seven", "8", "IX", "zece");   // static methods in interfaces!

        List<String> list = new ArrayList<>();

        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("zece");

        stream
                .peek(System.out::println)          // methods that return streams are intermediary operations, they are lazy called
                .filter(p1.or(p2))
                .peek(list::add);                   // this code doesn't do anything, it has not final operation, only intermediary operations!

        stream2
                .peek(System.out::println)
                .filter(p1.or(p2))
                .forEach(list::add);                // this is a final operation, so all intermediary operations are triggered

        System.out.println("List size: " + list.size());
    }
}
