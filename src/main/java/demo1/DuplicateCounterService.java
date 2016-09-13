package demo1;

import java.util.List;

/**
 * Created by Evegeny on 13/09/2016.
 */
public class DuplicateCounterService {
    public <T> int count(List<T> list, T t, Equlator<T> equlator) {
        int counter=0;
        for (T o : list) {
            if (equlator.compare(o, t)) {
                counter++;
            }
        }
        return counter;
    }
}
