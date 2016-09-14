package musiclab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 14/09/2016.
 */
@Component
public class UserConfig implements Serializable{

    public List<String> garbage;

    @Value("${garbage}")
    public void setGarbageList(String[] garbage) {
        this.garbage = Arrays.asList(garbage);
    }
}
