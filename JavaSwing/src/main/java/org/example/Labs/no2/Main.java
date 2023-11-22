package org.example.Labs.no2;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        kolokwium();
    }

    public static void kolokwium() {
        JFrame frame = new JFrame("Kolokwium");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 320, 240);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuView = new JMenu("WIDOKI");
        menuBar.add(menuView);

        JMenuItem circleOption = new JMenuItem("KOŁO");
        circleOption.addActionListener(new ListenerMenu());
        menuView.add(circleOption);

        JMenuItem rectangleOption = new JMenuItem("KWADRAT");
        circleOption.addActionListener(new ListenerMenu());
        menuView.add(rectangleOption);

        frame.add(menuBar, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }
}
