package com.wjcat.learn.algorithm.visibleAlgorithm.algoFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @Description 算法窗口构建
 * Created by yupeijiang on 2019/6/14.
 */
public class AlgoFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {

        super(title);

        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;

        AlgoCanvas canvas = new AlgoCanvas();

        setContentPane(canvas);

        pack();

        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }

    //看得见的算法的基础画布构建
    public AlgoFrame(String title) {
        this(title, 1024, 1024);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    private class AlgoCanvas extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

//            g.drawOval(50, 50, 300, 300);
            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(Color.red);

            Ellipse2D circle = new Ellipse2D.Double(50, 50, 300, 300);
            g2d.draw(circle);

            Ellipse2D circle2 = new Ellipse2D.Double(60, 60, 280, 280);
            g2d.fill(circle2);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }

}
