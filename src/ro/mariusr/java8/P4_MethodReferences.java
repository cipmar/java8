package ro.mariusr.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by mariusrop on 09.11.2015.
 */
public class P4_MethodReferences {
    public static void main(String[] args) {

        // method references are shortcuts to write a lambda expression

        // reference to a static method
        Comparator<Integer> comparator1 = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> comparator2 = Integer::compare;

        // reference to an instance method of a particular object
        Consumer<String> consumer1 = str -> System.out.println(str);
        Consumer<String> consumer2 = System.out::println;

        // reference to an instance method of an arbitrary object of a particular type
        Comparator<String> comparator = String::compareToIgnoreCase;
        Arrays.sort(new String[]{"str1", "astr2"}, comparator);

        // constructor reference
        Supplier<String> supplier1 = () -> new String();
        Supplier<String> supplier2 = String::new;
    }
}
