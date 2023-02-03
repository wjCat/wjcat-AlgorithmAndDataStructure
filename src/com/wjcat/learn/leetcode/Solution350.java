package com.wjcat.learn.leetcode;

import java.util.*;

public class Solution350 {

    public static void main(String[] args) {
        Solution350 solution350 = new Solution350();
        System.out.println(Arrays.toString(solution350.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution350.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(solution350.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 8, 4})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int index = 0;
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int[] temp = new int[1001];
        for (int i : nums1) {
            temp[i]++;
        }
        for (int i : nums2) {
            if (temp[i] > 0) {
                temp[i]--;
                res[index++] = i;
            }
        }
        return Arrays.copyOf(res, index);
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();
        for (int j : nums1) {
            priorityQueue1.offer(j);
        }
        for (int j : nums2) {
            priorityQueue2.offer(j);
        }
        while (!priorityQueue1.isEmpty() && !priorityQueue2.isEmpty()) {
            if (Objects.equals(priorityQueue1.peek(), priorityQueue2.peek())) {
                res.add(priorityQueue1.poll());
                priorityQueue2.poll();
            } else if (priorityQueue1.peek() > priorityQueue2.peek()) {
                priorityQueue2.poll();
            } else {
                priorityQueue1.poll();
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersect3(int[] nums1, int[] nums2) {
        Map<Integer, Integer> temp = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int j : nums1) {
            temp.merge(j, 1, Integer::sum);
        }
        for (int j : nums2) {
            if (!temp.containsKey(j) || temp.get(j) <= 0) {
                continue;
            }
            res.add(j);
            temp.merge(j, -1, Integer::sum);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

}
