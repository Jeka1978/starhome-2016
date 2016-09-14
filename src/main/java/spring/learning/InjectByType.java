package spring.learning;/**
 * Created by Evegeny on 14/09/2016.
 */

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface InjectByType {
}
