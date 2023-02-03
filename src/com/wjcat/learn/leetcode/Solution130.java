package com.wjcat.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author yupeijiang
 * @date 2020/7/21 0021
 */
public class Solution130 {

    public static void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            deal(board, i, 0);
            deal(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            deal(board, 0, i);
            deal(board, board.length - 1, i);
        }

        Arrays.stream(board).forEach(System.out::println);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void deal(char[][] board, int m, int n) {
        if (m < 0 || m >= board.length || n < 0 || n >= board[m].length || board[m][n] == 'X' || board[m][n] == 'A') {
            return;
        }
        board[m][n] = 'A';
        deal(board, m, n + 1);
        deal(board, m, n - 1);
        deal(board, m + 1, n);
        deal(board, m - 1, n);
    }

    public static void main(String[] args) {
        char[][] param = new char[][]{{'O', 'O'}, {'O', 'O'}};
        solve(param);
        Arrays.stream(param).forEach(System.out::println);
    }

}
