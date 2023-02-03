package com.wjcat.learn.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1345 {

    public static void main(String[] args) {
        Solution1345 solution1345 = new Solution1345();
        System.out.println(solution1345.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
//        System.out.println(solution1345.minJumps(new int[]{7}));
//        System.out.println(solution1345.minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));
//        System.out.println(solution1345.minJumps(new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13}));
    }

    public int minJumps(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        Map<Integer, List<Integer>> temp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> indexList = temp.getOrDefault(arr[i], new ArrayList<>());
            indexList.add(i);
            temp.put(arr[i], indexList);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(0);
        Set<Integer> backup = new HashSet<>();
        backup.add(0);
        return bfs(deque, temp, arr, backup);
    }

    private int bfs(Deque<Integer> deque, Map<Integer, List<Integer>> temp, int[] arr, Set<Integer> backup) {
        int curLevelSize = deque.size();
        for (int i = 0; i < curLevelSize; i++) {
            int curIndex = deque.removeLast();
            List<Integer> targetList = temp.remove(arr[curIndex]);
            if ((targetList != null && targetList.contains(arr.length - 1)) || curIndex == arr.length - 2) {
                return 1;
            }
            backup.add(curIndex);
            if (targetList != null) {
                targetList.stream().filter(e -> !backup.contains(e)).forEach(deque::addFirst);
            }
            if (curIndex > 0 && !backup.contains(curIndex - 1)) {
                deque.addFirst(curIndex - 1);
            }
            if (curIndex < arr.length - 1 && !backup.contains(curIndex + 1)) {
                deque.addFirst(curIndex + 1);
            }
        }
        return bfs(deque, temp, arr, backup) + 1;
    }

}
