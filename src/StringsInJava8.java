import java.util.StringJoiner;

/**
 * Created by mariusrop on 25.10.2015.
 */
public class StringsInJava8 {
    public static void main(String[] args) {
        // string joiner!!!

        StringJoiner stringJoiner = new StringJoiner(",", "{", "}");
        String str = stringJoiner.add("one").add("two").add("three").toString();
        System.out.println(str);

        System.out.println(String.join(",", "1", "2", "4"));
    }
}
