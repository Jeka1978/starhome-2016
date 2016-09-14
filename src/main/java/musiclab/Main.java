package musiclab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 14/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext musiclab = new AnnotationConfigApplicationContext("musiclab");
//        musiclab.getBean(MusicService.class).topX()
    }
}
