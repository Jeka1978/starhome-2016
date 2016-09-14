package spring.learning;

/**
 * Created by Evegeny on 14/09/2016.
 */
public interface Configurer {
    void configure(Object t) throws IllegalAccessException, InstantiationException;
}
