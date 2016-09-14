package spring.learning;

import javax.swing.*;

/**
 * Created by Evegeny on 14/09/2016.
 */
public class PopupSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
