package ro.mariusr.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by mariusrop on 09.11.2015.
 */
public class P5_DefaultMethodsInInterfaces {
    public static void main(String[] args) {
        // default methods in interfaces!
        // static methods are also allowed in interfaces

        // forEach in Iterable
        Iterable<String> list = Arrays.asList("one", "two", "trei");
        list.forEach(System.out::println);

        // and in Predicate
        Predicate<Integer> p1 = Predicate.isEqual(22);
        Predicate<Integer> p2 = Predicate.isEqual(4);
        Predicate<Integer> p3 = i -> i < 10;
        Predicate<Integer> p4 = p1.or(p2).and(p3);
        List<Integer> list1 = Arrays.asList(1, 6, 5, 8, 23, 22, 21, 64, 2, 4).stream().filter(p4).collect(Collectors.toList());
        System.out.println(list1);

        // of methods in Optional
        Optional<Integer> opt = Optional.of(1);
    }
}
