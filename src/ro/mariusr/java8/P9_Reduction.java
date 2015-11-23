package ro.mariusr.java8;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * Created by mariusrop on 12.11.2015.
 */
public class P9_Reduction {
    public static void main(String[] args) throws IOException {
        // reduction - combining the elements of a stream
        // reduction are terminal operations, they trigger the processing of data

        // there three types of reduction operations
        // aggregation operations: max, min, count, allMatch, noneMatch, anyMatch, findFirst, findAny
        // general purpose reduction: Stream.reduce
        // collectors

        List<Integer> list = Arrays.asList(1, 2, 3);

        Integer identity = 0;
        BinaryOperator<Integer> accumulator = (partialResult, nextElement) -> partialResult + nextElement;

        Integer sum1 = list.stream().reduce(identity, accumulator);             // identity
        Integer sum2 = list.stream().reduce(1, accumulator);         // wrong identity
        Optional<Integer> sum3 = list.stream().reduce(accumulator);             // no identity
        Optional<Integer> sum4 = Stream.<Integer>of().reduce(accumulator);      // no identity
        Optional<Integer> max = list.stream().max(Integer::compare);

        System.out.println("sum1 - " + sum1);
        System.out.println("sum2 - " + sum2);
        System.out.println("sum3 - " + sum3);
        System.out.println("sum4 - " + sum4);
        System.out.println("max  - " + max);
    }
}
