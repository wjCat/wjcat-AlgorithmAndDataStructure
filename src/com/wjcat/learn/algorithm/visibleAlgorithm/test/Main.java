package com.wjcat.learn.algorithm.visibleAlgorithm.test;

import com.wjcat.learn.algorithm.visibleAlgorithm.algoFrame.AlgoFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @Description 学习JFrame
 * Created by yupeijiang on 2019/6/14.
 */
public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            AlgoFrame frame = new AlgoFrame("Welcome", 500, 500);
        });


    }

}
