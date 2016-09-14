package musiclab;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Evegeny on 14/09/2016.
 */
@Configuration
@PropertySource("classpath:user.properties")
public class CommonConfig {
    @Autowired
    private SparkConf sparkConf;

    @Bean
    public JavaSparkContext sc(){
        return new JavaSparkContext(sparkConf);
    }
}
