package ro.mariusr.java8;

import java.util.*;
import java.util.function.*;

import static java.util.Arrays.asList;

/**
 * Created by mariusrop on 09.11.2015.
 */
public class P3_FunctionalInterfaces {
    // there four big functional interfaces categories:

    /**
     * suppliers
     */
    private static void supplierExample() {
        Supplier<Double> supplier = () -> Math.random();

        // zero argument constructors can be suppliers
        Supplier<String> stringSupplier = String::new;
    }

    /**
     * consumers
     */
    private static void consumerExample() {
        // consumer
        List<String> newList = new ArrayList<>();

        Consumer<String> consumer1 = str -> newList.add(str);
        Consumer<String> consumer2 = str -> System.out.println(str);

        asList("1", "2", "3").forEach(consumer1.andThen(consumer2));    // chaining consumers!!!
        System.out.println(newList);

        // biConsumer
        BiConsumer<String, Integer> biConsumer = (key, value) -> System.out.println("Key: " + key + ", Value: " + value);
        Map<String, Integer> map = new HashMap<>();
        map.put("RO", 20);
        map.put("DE", 80);
        map.put("FI", 5);
        map.forEach(biConsumer);
    }

    /**
     * predicates
     */
    private static void predicateExample() {
        // predicate
        Predicate<String> p = s -> s.length() > 5;
        asList("apple", "orange", "banana").stream().filter(p).forEach(System.out::println);

        // biPredicate

        BiPredicate<Integer, Integer> bi = (x, y) -> x + 2 > y; // TODO example
    }

    /**
     * functions
     */
    private static void functionExample() {
        // function
        Function<String, Integer> f = s -> s.length();
        asList("one", "two", "three").stream().map(f).forEach(System.out::println);

        // biFunction
        BiFunction<String, Integer, Integer> bi = (s, y) -> s.length() + y; // TODO example

        // binary operator
        BinaryOperator<Integer> bin = (x, y) -> x + y;
        Integer sum = asList(1, 2, 3).stream().reduce(0, bin);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        supplierExample();
        consumerExample();
        predicateExample();
        functionExample();
    }
}
