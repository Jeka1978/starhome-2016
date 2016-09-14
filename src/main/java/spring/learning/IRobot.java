package spring.learning;

/**
 * Created by Evegeny on 14/09/2016.
 */
public class IRobot {
    @InjectByType //same like spring @Autowired
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;


    public void cleanRoom() {
        speaker.speak("I started");
        cleaner.clean();
        speaker.speak("I finished");
    }
}



