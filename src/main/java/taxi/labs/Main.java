package taxi.labs;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by Evegeny on 13/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("taxi");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        JavaRDD<String> rdd = sc.textFile("data/taxi_order.txt");
        System.out.println(rdd.count());

    }
}
