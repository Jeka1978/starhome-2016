package spring.learning;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Evegeny on 14/09/2016.
 */
public class InjectRandomIntAnnotationObjectConfigurer implements Configurer {
    @Override
    public void configure(Object t) throws IllegalAccessException {
        Field[] declaredFields = t.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int value = min + random.nextInt(max - min);
                field.setAccessible(true);
                field.set(t,value);
            }
        }
    }
}
