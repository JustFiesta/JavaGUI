package org.example.Labs.no1;

import javax.swing.*;
import java.awt.*;

public class Main {
    //    public static void main(String[] args) {
//        //1. Create widow format and it's behaviors.
//        //create new windows format
//        JFrame frame = new JFrame("New format");
//        //action on close
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // there are more to that
//        //frame dimensions
//        frame.setBounds(100,100,320,240);
//        //view frame
//        frame.setVisible(true);
//
//        //2. Change placement of format and controls
////        location of format
////        ex. button.setLocale(Point (50, 50));
//        frame.setLocation(100, 100);
//        //size of elements
//        //resize
//        frame.setSize(new Dimension(150, 150));
////        button.setSize(new Dimension(150, 150);
////        frame.setbounds can to two of above in one
//
//        //3. JPanel Containers/Panels in format (divs in format)
//        //create new panel for buttons
//        JPanel buttonPanel = new JPanel(new BorderLayout());
//        //create buttons
//        JButton northButton = new JButton("północ");
//        JButton southButton = new JButton("south");
//        JButton eastButton = new JButton("wschód");
//        JButton westButton = new JButton("zachód");
//
//        //add buttons to buttonpanel
//        buttonPanel.add(northButton, BorderLayout.NORTH);
//        buttonPanel.add(southButton, BorderLayout.SOUTH);
//        buttonPanel.add(eastButton, BorderLayout.EAST);
//        buttonPanel.add(westButton, BorderLayout.WEST);
//
//        //add button panel to frame
//        frame.add(buttonPanel, BorderLayout.CENTER);
//
//        //automaticly sets height and width
//        frame.pack();
//        frame.setVisible(true);
//
//
//        //Drawings in panel
//
//    }
//    //method for drawing
//    public void paintComponent(Graphics g){
//        int width = (int) getWidth / 8;
//        int height = (int) getHeight / 8;
//    }
    public static void main(String[] args) {
        //formatka();
        //panel();
        //flowlayout();
        //gridbaglayput();
        menadzerulozen();
    }

    public static void formatka() {
        JFrame frame = new JFrame("Nowa formatka!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 320, 240);
        frame.setVisible(true);
    }

    public static void panel() {
        JFrame frame = new JFrame("JFrame!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        JButton northButton = new JButton("północ");
        JButton southButton = new JButton("południe");
        JButton eastButton = new JButton("wschód");
        JButton westButton = new JButton("zachód");

        buttonPanel.add(northButton, BorderLayout.NORTH);
        buttonPanel.add(southButton, BorderLayout.SOUTH);
        buttonPanel.add(eastButton, BorderLayout.EAST);
        buttonPanel.add(westButton, BorderLayout.WEST);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static void flowlayout() {
        JFrame frame = new JFrame("Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        for (int i = 1; i <= 10; i++) {
            contentPane.add(new JButton("Button " + i));
        }

        frame.pack();
        frame.setVisible(true);
    }

    public static void gridbaglayput() {
        JFrame frame = new JFrame("GridBagLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        for (int i = 0; i < 3; i++) {
            gbc.gridx = i;
            gbc.gridy = i;
            contentPane.add(new JButton("Button (" + i + ")"), gbc);
        }

        for (int y = 3; y < 6; y++) {
            for (int x = 3; x < 6; x++) {
                gbc.gridx = x;
                gbc.gridy = y;
                contentPane.add(new JButton("Button (" + x + ", " + y + ")"), gbc);
            }
        }
        frame.pack();
        frame.setVisible(true);
    }

    public static void menadzerulozen() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);

        JButton b1 = new JButton("Przycisk 1");
        JButton b2 = new JButton("Przycisk 2");
        contentPane.add(b1);
        contentPane.add(b2);

        b1.setBounds(10, 10, 100, 50);
        b1.setBounds(120, 10, 150, 40);

        frame.setBounds(0, 0, 350, 100);
        frame.setVisible(true);
    }
}
