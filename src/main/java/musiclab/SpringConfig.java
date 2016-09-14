package musiclab;

import org.apache.spark.SparkConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Evegeny on 14/09/2016.
 */
@Configuration
public class SpringConfig {
    @Bean
    @Profile("DEV")
    public SparkConf sparkConfDev() {
        return new SparkConf().setAppName("Music").setMaster("local");
    }

    @Bean
    @Profile("PROD")
    public SparkConf sparkConfProd() {
        return new SparkConf().setAppName("Music");
    }
}
