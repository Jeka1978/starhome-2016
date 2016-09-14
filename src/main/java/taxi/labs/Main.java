package taxi.labs;

import org.apache.spark.Accumulator;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

/**
 * Created by Evegeny on 13/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("taxi");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        JavaRDD<String> rdd = sc.textFile("data/taxi_order.txt");
        System.out.println(rdd.count()); //1//
        //2//
        rdd.map(String::toLowerCase).
                filter(line -> line.contains("boston"))
                .filter(line -> Integer.parseInt(line.split(" ")[2]) > 10)
                .collect().forEach(System.out::println);

        //3//
        Integer bostonSum = rdd.map(String::toLowerCase).
                filter(line -> line.contains("boston")).
                map(line -> Integer.parseInt(line.split(" ")[2])).
                reduce((v1, v2) -> v1 + v2);
        System.out.println("bostonSum = " + bostonSum);

        //4//

        JavaPairRDD<String, Integer> pairRDD = rdd.map(String::toLowerCase).
                mapToPair(line -> {
                    String[] strings = line.split(" ");
                    int miles = Integer.parseInt(strings[2]);
                    String driverId = strings[0];
                    return new Tuple2<>(driverId, miles);
                });
        JavaPairRDD<String, Integer> sortedTuples =
                pairRDD.reduceByKey(Integer::sum)
                        .mapToPair(Tuple2::swap)
                        .sortByKey(false)
                        .mapToPair(Tuple2::swap);

        sortedTuples.collect().forEach(System.out::println);

        JavaRDD<String> driversRdd = sc.textFile("data/drivers.txt");
        JavaPairRDD<String, String> driverNames = driversRdd.mapToPair(line -> {
                    String[] strings = line.split(",");
                    return new Tuple2<>(strings[0], strings[1]);
                }

        );

        JavaPairRDD<String, Tuple2<Integer, String>> joined = sortedTuples.join(driverNames);
        joined.collect().forEach(System.out::println);
        joined.map(tuple-> tuple._2()._2()).collect().forEach(System.out::println);

        Accumulator<Integer> accumulator = sc.accumulator(0, "lessThan5Miles");
        rdd.map(line->{
            if (Integer.parseInt(line.split(" ")[2]) < 5) {
                accumulator.add(1);
            }
            return line;
        });
        Integer finalSummarizedValue = accumulator.value();


    }
}
