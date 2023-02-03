package com.wjcat.learn.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solution37 {

    public static void main(String[] args) {
        Solution37 solution37 = new Solution37();
//        char[][] param = new char[][]{
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        char[][] param = new char[][]{
//                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
//                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
//                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
//                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
//                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
//                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
//                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        char[][] param = new char[][]{
                {'.', '.', '.', '2', '.', '.', '.', '6', '3'},
                {'3', '.', '.', '.', '.', '5', '4', '.', '1'},
                {'.', '.', '1', '.', '.', '3', '9', '8', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '3', '8', '.', '.', '.'},
                {'.', '3', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '6', '3', '.', '.', '5', '.', '.'},
                {'5', '.', '3', '7', '.', '.', '.', '.', '8'},
                {'4', '7', '.', '.', '.', '1', '.', '.', '.'}};
        solution37.solveSudoku(param);
        Arrays.stream(param).forEach(e -> System.out.println(Arrays.toString(e)));
    }

    private static final int sudokuNum = 9;

    public void solveSudoku(char[][] board) {
        int[][][] temp = new int[sudokuNum][sudokuNum][sudokuNum];
        doSolveSudoku(board, temp);
        solveSudoku1(board);
    }

    public void doSolveSudoku(char[][] board, int[][][] temp) {
        firstSolve(board, temp);
        if (secondSolve(board, temp)) {
            doSolveSudoku(board, temp);
        }
    }

    private void firstSolve(char[][] board, int[][][] temp) {
        boolean isChange;
        do {
            isChange = false;
            for (int i = 0; i < sudokuNum; i++) {
                for (int j = 0; j < sudokuNum; j++) {
                    if (board[i][j] == '.') {
                        isChange = doFirstSolve(board, i, j, temp) || isChange;
                    } else {
                        for (int k = 0; k < sudokuNum; k++) {
                            temp[i][j][k] = 2;
                        }
                    }
                }
            }
        } while (isChange);
    }

    private boolean secondSolve(char[][] board, int[][][] temp) {
        AtomicBoolean isChange = new AtomicBoolean(false);
        for (int i = 0; i < sudokuNum; i++) {
            Map<Integer, List<Integer>> eleRowCount = new HashMap<>();
            Map<Integer, List<Integer>> eleColumnCount = new HashMap<>();
            Map<Integer, List<Integer>> eleBoxCount = new HashMap<>();
            for (int j = 0; j < sudokuNum; j++) {
                for (int k = 0; k < sudokuNum; k++) {
                    if (temp[i][j][k] == 0) {
                        List<Integer> rowEle = eleRowCount.getOrDefault(k, new ArrayList<>());
                        rowEle.add(j);
                        eleRowCount.put(k, rowEle);
                    }
                }
            }
            int finalI = i;
            eleRowCount.forEach((key, value) -> {
                if (value.size() == 1) {
                    board[finalI][value.get(0)] = (char) (key + 1 + '0');
                    reset(finalI, value.get(0), key, temp);
                    isChange.set(true);
                }
            });

            for (int j = 0; j < sudokuNum; j++) {
                for (int k = 0; k < sudokuNum; k++) {
                    if (temp[j][i][k] == 0) {
                        List<Integer> columnEle = eleColumnCount.getOrDefault(k, new ArrayList<>());
                        columnEle.add(j);
                        eleColumnCount.put(k, columnEle);
                    }
                }
            }
            eleColumnCount.forEach((key, value) -> {
                if (value.size() == 1) {
                    board[value.get(0)][finalI] = (char) (key + 1 + '0');
                    reset(value.get(0), finalI, key, temp);
                    isChange.set(true);
                }
            });

            for (int j = 0; j < sudokuNum; j++) {
                for (int k = 0; k < sudokuNum; k++) {
                    if (temp[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3][k] == 0) {
                        List<Integer> boxEle = eleBoxCount.getOrDefault(k, new ArrayList<>());
                        boxEle.add(j);
                        eleBoxCount.put(k, boxEle);
                    }
                }
            }
            eleBoxCount.forEach((key, value) -> {
                if (value.size() == 1) {
                    board[finalI / 3 * 3 + value.get(0) / 3][finalI % 3 * 3 + value.get(0) % 3] = (char) (key + 1 + '0');
                    reset(finalI / 3 * 3 + value.get(0) / 3, finalI % 3 * 3 + value.get(0) % 3, key, temp);
                    isChange.set(true);
                }
            });
        }
        return isChange.get();
    }

    private boolean doFirstSolve(char[][] board, int i, int j, int[][][] temp) {
        boolean isChange = false;
        for (int k = 0; k < sudokuNum; k++) {
            for (int l = 0; l < sudokuNum; l++) {
                if ((board[i][l] - 49 == k || board[l][j] - 49 == k || board[i / 3 * 3 + l % 3][j / 3 * 3 + l / 3] - 49 == k) && temp[i][j][k] == 0) {
                    temp[i][j][k] = 1;
                }
            }
        }
        List<Integer> survive = new ArrayList<>();
        for (int k = 0; k < sudokuNum; k++) {
            if (temp[i][j][k] == 0) {
                survive.add(k);
            }
        }
        if (survive.size() == 1) {
            isChange = true;
            board[i][j] = (char) (survive.get(0) + 1 + '0');
            reset(i, j, survive.get(0), temp);
        }
        return isChange;
    }

    private void reset(int i, int j, Integer target, int[][][] temp) {
        for (int l = 0; l < sudokuNum; l++) {
            temp[i][j][l] = 2;
        }
        for (int k = 0; k < sudokuNum; k++) {
            temp[i][k][target] = calculate(temp[i][k][target]);
            temp[k][j][target] = calculate(temp[k][j][target]);
            temp[i / 3 * 3 + k % 3][j / 3 * 3 + k / 3][target] = calculate(temp[i / 3 * 3 + k % 3][j / 3 * 3 + k / 3][target]);
        }
    }

    private int calculate(int param) {
        return param == 2 ? 2 : 0;
    }


    private int[] line = new int[9];
    private int[] column = new int[9];
    private int[][] block = new int[3][3];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku1(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0' - 1;
                    flip(i, j, digit);
                }
            }
        }

        while (true) {
            boolean modified = false;
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
                        if ((mask & (mask - 1)) == 0) {
                            int digit = Integer.bitCount(mask - 1);
                            flip(i, j, digit);
                            board[i][j] = (char) (digit + '0' + 1);
                            modified = true;
                        }
                    }
                }
            }
            if (!modified) {
                break;
            }
        }

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char) (digit + '0' + 1);
            dfs(board, pos + 1);
            flip(i, j, digit);
        }
    }

    public void flip(int i, int j, int digit) {
        line[i] ^= (1 << digit);
        column[j] ^= (1 << digit);
        block[i / 3][j / 3] ^= (1 << digit);
    }

}
