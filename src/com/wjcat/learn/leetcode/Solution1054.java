package com.wjcat.learn.leetcode;

import java.util.*;

/**
 * @author yupeijiang
 * @date 2020/7/23 0023
 */
public class Solution1054 {

    public static void main(String[] args) {
        Solution1054 solution1054 = new Solution1054();
//        System.out.println(Arrays.toString(solution1054.rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2})));
//        System.out.println(Arrays.toString(solution1054.rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3})));
//        System.out.println(Arrays.toString(solution1054.rearrangeBarcodes(new int[]{2, 2, 2, 1, 5})));
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(solution1054.rearrangeBarcodes(new int[]{16, 77, 16, 16, 77, 16, 77, 16, 61, 16, 16, 61, 77, 61, 61, 77, 77, 61, 61, 77, 61, 16, 77, 61, 61, 16, 16, 16, 61, 16, 61, 16, 61, 61, 16, 16, 77, 16, 16, 61, 61, 16, 16, 61, 16, 16, 61, 61, 77, 77, 16, 16, 77, 61, 16, 77, 16, 77, 77, 61, 16, 16, 77, 16, 61, 77, 16, 16, 16, 77, 61, 16, 61, 16, 16, 77, 16, 77, 61, 16, 77, 16, 16, 61, 61, 61, 61, 16, 16, 16, 16, 16, 16, 77, 61, 77, 61, 61, 61, 16})));
        System.out.println(System.currentTimeMillis() - start);
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] counts = new int[10001];
        int[] res = new int[barcodes.length];
        for (int barcode : barcodes) {
            counts[barcode]++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> counts[o2] - counts[o1]);
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                queue.offer(i);
            }
        }
        int id = 0;
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            res[id++] = a;
            res[id++] = b;
            if (counts[a] > 1) {
                counts[a]--;
                queue.offer(a);
            }
            if (counts[b] > 1) {
                counts[b]--;
                queue.offer(b);
            }
        }
        if (!queue.isEmpty()) {
            res[id] = queue.poll();
        }
        return res;
    }

}
