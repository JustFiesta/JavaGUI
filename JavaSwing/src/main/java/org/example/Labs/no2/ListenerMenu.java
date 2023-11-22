package org.example.Labs.no2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerMenu implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String choosed = e.getActionCommand();
        if (choosed.equals("KOŁO")) {
//            paintComponent();
        } else if (choosed.equals("KWADRAT")) {
            System.out.println("Rysuje kwadrat");
        } else {
            System.exit(0);
        }
    }

    public void paintComponent(Graphics g) {
        int width = 16;
        int height = 16;
        int x = 0;
        int y = 0;

        g.setColor(Color.black);

        for (int i = 0; i < 4; i++) {
            g.drawRect(x, y, width, height);
            x += width;
            y += height;
        }
    }
}
