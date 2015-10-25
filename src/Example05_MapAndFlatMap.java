import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by mariusrop on 16.10.2015.
 */
public class Example05_MapAndFlatMap {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        List<Integer> list3 = Arrays.asList(3, 5, 7);

        List<List<Integer>> list = Arrays.asList(list1, list2, list3);

        Function<List<Integer>, Stream<Integer>> flatmapper = l -> l.stream();

        list
                .stream()
                .flatMap(flatmapper)            // this is flatMap!
                .forEach(System.out::println);

        list
                .stream()
                .map(flatmapper)                // this is map! run the code to see the difference!
                .forEach(System.out::println);

    }
}
