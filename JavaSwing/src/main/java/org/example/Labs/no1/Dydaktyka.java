package org.example.Labs.no1;

import javax.swing.*;
import java.awt.*;

public class Dydaktyka extends JPanel {
    public void paintComponent(Graphics g) {
        int width = (int) getWidth() / 8;
        int height = (int) getHeight() / 8;
        int x = 0;
        int y = 0;

        g.setColor(Color.black);

        for (int i = 0; i < 4; i++) {
            g.drawRect(x, y, width, height);
            x += width;
            y += height;
            g.fillOval(x, y, width, height);
            x += width;
            y += height;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JFrame");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Dydaktyka());
        frame.setSize(300, 200);
        frame.setVisible(true);

        frame.pack();
        frame.setVisible(true);
    }
}
