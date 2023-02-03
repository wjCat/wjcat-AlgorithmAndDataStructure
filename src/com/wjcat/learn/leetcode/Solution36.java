package com.wjcat.learn.leetcode;

public class Solution36 {

    public static void main(String[] args) {
        Solution36 solution36 = new Solution36();
        solution36.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] subBoxes = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int current = board[i][j] - 49;
                    int boxIndex = i / 3 * 3 + j / 3;
                    if (rows[i][current] == 1 || columns[j][current] == 1 || subBoxes[boxIndex][current] == 1) {
                        return false;
                    } else {
                        rows[i][current] = 1;
                        columns[j][current] = 1;
                        subBoxes[boxIndex][current] = 1;
                    }
                }
            }
        }
        return true;
    }

}