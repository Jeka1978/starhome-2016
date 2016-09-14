package spring.learning;

/**
 * Created by Evegeny on 14/09/2016.
 */
public interface Config {

    <T> Class<T> getImpl(Class<T> ifc);
}
