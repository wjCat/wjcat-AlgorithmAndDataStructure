package com.wjcat.learn.algorithm.visibleAlgorithm.JFramePackage;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @decription @TODO
 * Created by 厕所里拉屎的猫 on 2019/6/14.
 */
public class AlgorithmFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public AlgorithmFrame(String title, int canvasWidth, int canvasHeight) {

        super(title);

        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;

        AlgorithmCanvas canvas = new AlgorithmCanvas();
        setContentPane(canvas);
        pack();

        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public AlgorithmFrame(String title) throws HeadlessException {
        this(title, 1024, 768);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    private class AlgorithmCanvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            int strokeWidth = 10;

            g2d.setStroke(new BasicStroke(strokeWidth));

            g2d.setColor(Color.red);

            Ellipse2D circle = new Ellipse2D.Double(50, 50, 300, 300);
            g2d.draw(circle);

            g2d.setColor(Color.blue);

            Ellipse2D circle2 = new Ellipse2D.Double(60, 60, 280, 280);
            g2d.fill(circle2);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }

}
