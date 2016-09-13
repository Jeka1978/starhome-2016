package demo1;

/**
 * Created by Evegeny on 13/09/2016.
 */
@FunctionalInterface
public interface Algorithm<T> {
    void apply(T t);
}
