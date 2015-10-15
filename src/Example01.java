import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mariusrop on 13.10.2015.
 */
public class Example01 {
    public static void main(String[] args) throws InterruptedException {
        findFileWithJavaExtension();
        runSomethingInDifferentThread();
        sortCollectionOfStringsByLemgth();
    }

    private static void findFileWithJavaExtension() {
        FileFilter fileFilter = file -> file.getName().endsWith(".java");
        File dir = new File("c:/Projects/java8/src");
        File[] files = dir.listFiles(fileFilter);

        for (File f : files) {
            System.out.println(f);
        }
    }

    private static void runSomethingInDifferentThread() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++)
                System.out.println(i);
        };

        Thread t = new Thread(runnable);
        t.start();
        t.join();

        System.out.println("Thread finished! (message from main thread)");
    }

    private static void sortCollectionOfStringsByLemgth() {
        List<String> listOfStrings = Arrays.asList("@@@", "@", "@@@@@", "@@@@");
        Comparator<String> comparatorByLength = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        Collections.sort(listOfStrings, comparatorByLength);
        System.out.println(listOfStrings);
    }
}
