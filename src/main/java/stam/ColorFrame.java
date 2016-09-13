package stam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Evegeny on 13/09/2016.
 */
public class ColorFrame extends JFrame{
    public ColorFrame(final String name) throws HeadlessException {
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton jButton = new JButton("click here");
        jButton.addActionListener(e -> System.out.println(name));
        this.add(jButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ColorFrame("Meny");
    }
}




