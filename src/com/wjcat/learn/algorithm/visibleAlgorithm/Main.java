package com.wjcat.learn.algorithm.visibleAlgorithm;

import com.wjcat.learn.algorithm.visibleAlgorithm.JFramePackage.AlgorithmFrame;

import java.awt.*;

/**
 * @decription @TODO
 * Created by 厕所里拉屎的猫 on 2019/6/14.
 */
public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            AlgorithmFrame frame = new AlgorithmFrame("Welcome", 500, 500);
//            AlgorithmFrame frame = new AlgorithmFrame("Welcome");
        });

    }

}
