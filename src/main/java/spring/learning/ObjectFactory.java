package spring.learning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evegeny on 14/09/2016.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<Configurer> configurers = new ArrayList<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
        configurers.add(new InjectRandomIntAnnotationObjectConfigurer());
        configurers.add(new InjectByTypeAnnotationObjectConfigurer());
    }


    public <T> T createObject(Class<T> type) throws IllegalAccessException, InstantiationException {
        if (type.isInterface()) {
            type = config.getImpl(type);
        }
        T t = type.newInstance();

        for (Configurer configurer : configurers) {
            configurer.configure(t);
        }


        return t;
    }


}
