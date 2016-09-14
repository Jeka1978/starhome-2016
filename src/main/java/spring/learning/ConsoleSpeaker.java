package spring.learning;

/**
 * Created by Evegeny on 14/09/2016.
 */
public class ConsoleSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}
