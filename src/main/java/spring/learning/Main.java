package spring.learning;

/**
 * Created by Evegeny on 14/09/2016.
 */
public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        IRobot robot = ObjectFactory.getInstance().createObject(IRobot.class);
        robot.cleanRoom();
    }
}
