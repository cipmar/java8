package ro.mariusr.java8;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created by mariusrop on 08.11.2015.
 * <p>
 * Bibliography
 * <p>
 * What's New in Java 8 by Jose Paumard, Pluralsight
 * Oracle Java 8 Tutorials
 * http://winterbe.com/
 * <p>
 * Agenda and StringJoiner class
 */
public class P1_Agenda {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(
                "\n-",
                "-----JAVA 8 - WHAT'S NEW-----\n-",
                "\n----------------------------");

        sj
                .add("Lambdas")
                .add("Functional Interfaces")
                .add("Method References")
                .add("Stream API and Collectors")
                .add("Optionals")
                .add("New Date and Time API")
                .add("Nashorn");

        System.out.println(sj.toString());
    }
}
