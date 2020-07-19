package com.wjcat.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FiftyOneSolution {

    public static List<List<String>> result = new ArrayList<>();

    public static boolean[][] temp;

    public static void main(String[] args) {
        List<List<String>> result = solveNQueens(4);
        for (List<String> l1 : result) {
            System.out.println("[");
            for (String s : l1) {
                System.out.println(s + " ");
            }
            System.out.println("],");
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        temp = new boolean[n][n];
        solveNQueens(0, n);
        return result;
    }

    public static void solveNQueens(int index, int n) {
        if (index == n) {
            result.add(getResultString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!temp[index][i]) {
                boolean[][] tempBak = bak(temp);
                updateTemp(index, i, n);
                solveNQueens(index + 1, n);
                temp = bak(tempBak);
            }
        }
    }

    public static boolean[][] bak(boolean[][] temp) {
        boolean[][] bak = new boolean[temp.length][temp.length];
        for (int i = 0; i < temp.length; i++) {
            System.arraycopy(temp[i], 0, bak[i], 0, temp.length);
        }
        return bak;
    }

    public static void updateTemp(int line, int column, int n) {
        for (int i = line; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == line || j == column || j == column - (i - line) || j == column + (i - line)) {
                    if (i != line || j != column) {
                        temp[i][j] = true;
                    }
                }
            }
        }
    }

    public static List<String> getResultString() {
        List<String> result = new ArrayList<>();
        for (boolean[] arr : temp) {
            StringBuilder sb = new StringBuilder();
            for (boolean flag : arr) {
                if (!flag) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

}
