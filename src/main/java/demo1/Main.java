package demo1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 13/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        DuplicateCounterService service = new DuplicateCounterService();
        List<String> strings = Arrays.asList("java", "JaVa", "JAVA", "scala");
        service.count(strings, "java", (t1, t2) -> t1.equalsIgnoreCase(t2));
    }
}
