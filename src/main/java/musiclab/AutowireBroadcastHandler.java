package musiclab;

import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Created by Evegeny on 14/09/2016.
 */
@Component
public class AutowireBroadcastHandler implements BeanPostProcessor {
    @Autowired
    private JavaSparkContext sc;

    @Autowired
    private ApplicationContext applicationContext;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AutowiredBroadCast.class)) {
                AutowiredBroadCast annotation = field.getAnnotation(AutowiredBroadCast.class);
                Class aClass = annotation.value();
                Object bean2Inject = applicationContext.getBean(aClass);
                field.setAccessible(true);
                try {
                    field.set(bean, sc.broadcast(bean2Inject));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
