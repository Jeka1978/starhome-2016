package spring.learning;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 14/09/2016.
 */
public class JavaConfig implements Config {
    private Map<Class, Class> map = new HashMap<>();

    public JavaConfig() {
        map.put(Speaker.class, ConsoleSpeaker.class);
        map.put(Cleaner.class, PowerCleaner.class);

    }

    @Override
    public <T> Class<T> getImpl(Class<T> ifc) {
        return map.get(ifc);
    }
}











