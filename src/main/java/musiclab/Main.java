package musiclab;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by Evegeny on 14/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext musiclab = new AnnotationConfigApplicationContext(StartConfig.class);
        MusicService musicService = musiclab.getBean(MusicService.class);
        JavaSparkContext sc = musiclab.getBean(JavaSparkContext.class);
        JavaRDD<String> rdd = sc.textFile("data/songs/beatles/*");
        List<String> words = musiclab.getBean(MusicService.class).topX(rdd, 1);
        System.out.println(words);
    }
}



