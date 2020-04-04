package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends Canvas {
    static final int rows = 63, columns = 1490, size = 10; //SETTINGS
    Main(){

    }
    public static boolean borderx(int x){
        return x == 0 || x == Main.columns;
    }
    public static boolean bordery(int y){
        return y == 0 || y == Main.rows;
    }
    public void drawlines(Graphics g){
        int x = 0, y = 0, vx = 1, vy = 1, prx = 0, pry = 0; boolean draw = true;
        while (true){
        x += vx; y += vy;
        if (borderx(x) && bordery(y)){break;}
        if (borderx(x)){
            vx = -vx;
        }
        if (bordery(y)){
            vy = -vy;
        }
        if (draw){
            g.drawLine(prx * size, pry * size, x * size, y * size);
        }
        prx = x; pry = y;
        draw = !draw;
        }
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        drawlines(g);
    }
    public static void main(String[] args) {

        JFrame frame = new JFrame("Carpet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Main();
        frame.setSize(Main.columns * Main.size + 17, 39 + Main.rows * Main.size);
        canvas.setBackground(Color.WHITE);
        canvas.setForeground(Color.BLACK);
        canvas.setVisible(true);
        frame.add(canvas);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
