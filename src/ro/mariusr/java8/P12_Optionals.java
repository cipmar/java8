package ro.mariusr.java8;

import java.util.Optional;

/**
 * Created by mariusrop on 13.11.2015.
 */
public class P12_Optionals {
    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.of("a string");

        // get, isPresent
        System.out.println(stringOptional.get());
        System.out.println(stringOptional.isPresent());

        // filter
        Optional<String> filtered = stringOptional.filter(s -> s.startsWith("a"));
        System.out.println(filtered);
        filtered = stringOptional.filter(a -> a.startsWith("b"));
        System.out.println(filtered);

        // map and flatMap
        Optional<Optional<String>> mapped = stringOptional.map(s -> Optional.of(s + " asas"));
        System.out.println(mapped);
        Optional<String> flatMapped = stringOptional.flatMap(s -> Optional.of(s + " asas"));
        System.out.println(flatMapped);

        // orElse
        Optional<String> empty = Optional.empty();
        System.out.println(empty.orElse("other string"));

        // ifPresent
        stringOptional.ifPresent(str -> System.out.println(str));
    }
}
