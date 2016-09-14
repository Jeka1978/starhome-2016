package spring.learning;

import com.google.inject.Inject;

/**
 * Created by Evegeny on 14/09/2016.
 */
public class PowerCleaner implements Cleaner {
    @InjectRandomInt(min = 3, max = 5)
    private int repeat;

    public PowerCleaner() {
        System.out.println("repeat = " + repeat);
    }

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("FFFFffffffhsssssssss");
        }
    }
}
