package spring.learning;

import java.lang.reflect.Field;
import java.util.Random;

import static org.omg.IOP.TAG_ORB_TYPE.value;

/**
 * Created by Evegeny on 14/09/2016.
 */
public class InjectByTypeAnnotationObjectConfigurer implements Configurer {
    @Override
    public void configure(Object t) throws IllegalAccessException, InstantiationException {
        Field[] declaredFields = t.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(InjectByType.class)) {

                Object object = ObjectFactory.getInstance().createObject(field.getType());

                field.setAccessible(true);
                field.set(t,object);
            }
        }
    }
}
