package musiclab;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 14/09/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StartConfig.class)
public class MusicServiceTest {
    @Autowired
    private MusicService musicService;

    @Autowired
    JavaSparkContext sc;

    @Test
    public void topX() throws Exception {
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("one two three", "one one one","two"));
        List<String> strings = musicService.topX(rdd, 1);
        Assert.assertEquals("one",strings.get(0));
    }

}






