package com.wjcat.learn.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution733 {

    public static void main(String[] args) {
        Solution733 solution733 = new Solution733();
        System.out.println(Arrays.deepToString(solution733.floodFill1(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
        System.out.println(Arrays.deepToString(solution733.floodFill1(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 2)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color, int src) {
        if (sr < 0 || sc < 0 ||sr >= image.length || sc >= image[sr].length || image[sr][sc] != src) {
            return;
        }
        image[sr][sc] = -1;
        dfs(image, sr - 1, sc, color, src);
        dfs(image, sr, sc - 1, color, src);
        dfs(image, sr + 1, sc, color, src);
        dfs(image, sr, sc + 1, color, src);
        image[sr][sc] = color;
    }

    int[] t1 = new int[]{0, 1, 0, -1};
    int[] t2 = new int[]{1, 0, -1, 0};

    public int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        bfs(queue, image, color, image[sr][sc]);
        return image;
    }

    public void bfs(Queue<int[]> queue, int[][] image, int color, int src) {
        if (queue.isEmpty()) {
            return;
        }
        int[] cur = queue.poll();
        image[cur[0]][cur[1]] = color;
        for (int i = 0; i < 4; i++) {
            int mx = cur[0] + t1[i], my = cur[1] + t2[i];
            if (mx >= 0 && mx < image.length && my >= 0 && my < image[mx].length && image[mx][my] == src) {
                queue.offer(new int[]{mx, my});
            }
        }
        bfs(queue, image, color, src);
    }

}