package com.wjcat.learn.leetcode;

import java.util.*;

/**
 * @author yupeijiang
 * @date 2020/8/4 0004
 */
public class Solution1742 {

    public static void main(String[] args) {
        Solution1742 solution1742 = new Solution1742();
        System.out.println(solution1742.countBalls(1, 10));
        System.out.println(solution1742.countBalls(5, 15));
        System.out.println(solution1742.countBalls(19, 28));
        System.out.println(solution1742.countBalls(11, 104));
    }

    public int countBalls1(int lowLimit, int highLimit) {
        Map<Integer, Integer> resMap = new HashMap<>();
        int res = 0;
        int temp = lowLimit;
        while (temp / 10 > 0) {
            temp %= 10;
        }
        doMerge(doCal(lowLimit / 10 == 0 ? 0 : lowLimit / 10 * 10), temp, 10, resMap);

        for (int i = lowLimit - temp + 10; i <= highLimit; i += 10) {
            doMerge(doCal(i), 0, i + 10 > highLimit ? highLimit - i + 1 : 10, resMap);
        }
        for (Map.Entry<Integer, Integer> element : resMap.entrySet()) {
            res = Math.max(res, element.getValue());
        }
        return res;
    }

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            res.merge(doCal(i), 1, Integer::sum);
        }
        return res.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getValue).orElse(0);
    }

    private int doCal(int target) {
        int res = 0;
        while (target / 10 >= 1) {
            res += target % 10;
            target = target / 10;
        }
        return res + target;
    }

    private void doMerge(int start, int startCount, int endCount, Map<Integer, Integer> resMap) {
        for (int j = startCount; j < endCount; j++) {
            resMap.merge(start + j, 1, Integer::sum);
        }
    }

}
