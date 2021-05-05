package Clipping;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Clipping extends JFrame {

    public Clipping() {
        super("Clipping");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GeneralPath gp = new GeneralPath();

        //--- Menggambar Area Visible
        int xmin = 300, ymin = (800 - 200), xmax = 700, ymax = (800 - 600);
        g2d.setPaint(Color.RED);
        gp.moveTo(xmin, ymin);
        gp.lineTo(xmax, ymin);
        gp.lineTo(xmax, ymax);
        gp.lineTo(xmin, ymax);
        gp.lineTo(xmin, ymin);
        g2d.draw(gp);

        //--- Menggambar garis
        int x1 = 200, y1 = (800 - 300), x2 = 600, y2 = (800 - 700);
        g2d.drawLine(x1, y1, x2, y2);

        // --- Menghitung Gradien Garis
        double m = (y2 - y1) / (x2 - x1);

        //--- Menghitung titik potong 
        int xp1 = (int) (x1 + ((ymax - y1) / m));
        int yp2 = (int) (y1 + (m * (xmin - x1)));

        //--- Memotong Garis 
        g2d.drawLine(xmin, yp2, xp1, ymax);
    }

    public static void main(String[] args) {
        Clipping gambar = new Clipping();

        gambar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
