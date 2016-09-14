package musiclab;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 14/09/2016.
 */
@Service
public class MusicService {

    @Autowired
    private JavaSparkContext sc;

    public List<String> topX(JavaRDD<String> rdd, int x) {
        JavaRDD<String> wordsRdd = rdd.map(String::toLowerCase).
                flatMap(s -> Arrays.asList(s.split(" ")));
        List<String> list = wordsRdd.mapToPair(w -> new Tuple2<>(w, 1))
                .reduceByKey(Integer::sum)
                .mapToPair(Tuple2::swap)
                .sortByKey(false).map(Tuple2::_2).take(x);
        return list;

    }
}






