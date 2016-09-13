package demo1;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Evegeny on 13/09/2016.
 */
public class ListUtils {
    public static <T> void forEachWithDelay(List<T> list, int delay, Consumer<T> algorithm) throws InterruptedException {

        for (T t : list) {
            algorithm.accept(t);
            Thread.sleep(delay);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> strings = Arrays.asList("java", "JaVa", "JAVA", "scala");
        String str="sadasd";
        forEachWithDelay(strings,1000,s -> System.out.println(str));


    }
}
