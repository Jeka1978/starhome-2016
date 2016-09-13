package demo1;

/**
 * Created by Evegeny on 13/09/2016.
 */
public interface B {
    default void x(){
        System.out.println("XXXXXXX");
    }
}
