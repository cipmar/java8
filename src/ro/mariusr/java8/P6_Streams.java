package ro.mariusr.java8;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mariusrop on 12.11.2015.
 */
public class P6_Streams {
    public static void main(String[] args) throws IOException {
        // stream - a new concept - what is a stream?

        List<Person> persons = Person.readPersons();

        Long n = persons
                .stream()                           // creates a stream
                .distinct()                         // intermediary operation; lazy operation
                .skip(3)                            // intermediary operation; lazy operation
                .limit(10)                          // intermediary operation; lazy operation
                .map(p -> p.getAge())               // intermediary operation; lazy operation
                .filter(age -> age > 25)            // intermediary operation; lazy operation
                .sorted()                           // intermediary operation; lazy operation
                .collect(Collectors.counting());    // terminal operation; triggers the entire chain of operations

        System.out.println(n);

        // a stream represents a sequence of elements and supports different kind of operations to perform computations upon those elements

        // it is not a collection even it might look like one
        // a stream doesn't hold any data
        // a stream should not change the data it processes

        // streams efficiently process large/small amount of date
        // parallel processing
        // pipelined, to avoid unnecessary intermediary computations - data is processed in one pass

        // streams are monads (a structure that represents computations defined as a sequence of steps)
        // Stream operations are either intermediate or terminal
    }
}
