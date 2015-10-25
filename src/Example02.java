import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by mariusrop on 15.10.2015.
 */
public class Example02 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("ome", "two", "three", "four", "five", "six", "seven");
        List<String> results = new ArrayList<>();

        Consumer<String> c1 = System.out::println;      // a lambda - method reference - static
        Consumer<String> c2 = results::add;             // a lambda - method reference - non-static

        strings.forEach(c1.andThen(c2));                // chaining consumers

        System.out.println("results = " + results);
    }
}
