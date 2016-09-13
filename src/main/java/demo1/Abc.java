package demo1;

/**
 * Created by Evegeny on 13/09/2016.
 */
public class Abc implements A,B {
    @Override
    public void x() {
       B.super.x();
    }
}
