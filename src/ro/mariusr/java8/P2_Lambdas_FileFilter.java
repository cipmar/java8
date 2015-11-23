package ro.mariusr.java8;

import java.io.File;
import java.io.FileFilter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

/**
 * Created by mariusrop on 08.11.2015.
 */
public class P2_Lambdas_FileFilter {

    /**
     * Example no. 1: file filter
     */
    private static void fileFilterExample() {
        // what is the syntax of a lambda expression?
        // what is the type of a lambda expression?

        FileFilter ff = (File file) -> file.getName().endsWith(".exe");

        File dir = new File("c:/Windows");
        File[] exeFilesFromWindows = dir.listFiles(ff);
        asList(exeFilesFromWindows).forEach(System.out::println);

        // Lambda syntax:
        // - comma-separated list of formal parameters enclosed in parentheses
        // - arrow token ->
        // - body: a single expression or a statement block

        // a functional interface - an interface with some constraints: an
        // interface with only one abstract method; @FunctionalInterface annotation is optional; the compiler doesn't
        // need the annotation, it can tell without it if an interface is functional of not
    }

    /**
     * Example no. 2: runnable
     */
    private static void runSomethingInADifferentThread() throws InterruptedException {
        // is lambda expression an object?

        Runnable runnable = () -> IntStream.range(0, 10).forEach(System.out::print);

        Thread t = new Thread(runnable);
        t.start();
        t.join();

        System.out.println("\nThread finished! (message from main thread)");

        // no new operator!
        // no - a new kind of object in JVM - an object without an identity - don't use it as a regular object, don't call equals on it for example
    }

    /**
     * Example no. 3: comparator
     */
    private static void sortCollectionOfStringsByLength() {
        // how do we know the list of formal parameters of a lambda expression?

        Comparator<String> comparatorByLength = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        List<String> listOfStrings = asList("one", "two", "three", "four", "seven");
        Collections.sort(listOfStrings, comparatorByLength);
        System.out.println(listOfStrings);

        // look at the single abstract method of the functional interface
        // formal parameters types can be omitted - compiled can infer them
    }

    /**
     * main
     */
    public static void main(String[] args) throws InterruptedException {
        fileFilterExample();
        runSomethingInADifferentThread();
        sortCollectionOfStringsByLength();
    }
}
