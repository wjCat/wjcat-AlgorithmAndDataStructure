package com.wjcat.learn.leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class Solution1622 {

    class Tree {
        String[] data;

        int capacity = 100000;

        String splitString = ",";

        public Tree() {
            this.data = new String[4 * capacity];
        }

        public void addOperate(int index, Integer operate) {
            addOperate(0, 0, this.capacity, index, operate);
        }

        private void addOperate(int treeIndex, int l, int r, int index, Integer operate) {
            if (l == r) {
                this.data[treeIndex] =  getStringNullDefault(this.data[treeIndex]) + splitString + operate;
                return;
            }

            int mid = l + (r - l) / 2;

            int leftChild = this.leftChild(treeIndex);
            int rightChild = this.rightChild(treeIndex);

            if (index > mid) {
                this.addOperate(rightChild, mid + 1, r, index, operate);
            } else {
                this.addOperate(leftChild, l, mid, index, operate);
            }

            this.data[treeIndex] = this.merge(leftChild, rightChild);

        }

        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }

        private String merge(int leftChild, int rightChild) {
            String leftOperate = this.data[leftChild];
            String rightOperate = this.data[rightChild];
            if (isStringEmpty(leftOperate) || isStringEmpty(rightOperate))
                return isStringEmpty(leftOperate) ? rightOperate : leftOperate;
            return leftOperate + splitString + rightOperate;
        }

        private boolean isStringEmpty(String s) {
            return s == null || Objects.equals(s, "");
        }

        public String getStringNullDefault(String s) {
            return isStringEmpty(s) ? "" : s;
        }

        public String getOperate(int index, int size) {
            if (index == 0) {
                return this.data[0];
            }
            return this.getOperate(0, 0, 100000, index, size);
        }

        private String getOperate(int treeIndex, int l, int r, int index, int size) {
            if (index == l) {
                return isStringEmpty(this.data[treeIndex]) ? "" : this.data[treeIndex];
            }
            if (size == l) {
                return "";
            }

            int mid = l + (r - l) / 2;

            int leftChild = this.leftChild(treeIndex);
            int rightChild = this.rightChild(treeIndex);

            if (index > mid) {
                return this.getOperate(rightChild, mid + 1, r, index, size);
            } else {
                String leftOperate = this.getOperate(leftChild, l, mid, index, size);
                return leftOperate.concat(splitString).concat(getStringNullDefault(this.data[rightChild]));
            }
        }

    }

    private int[] data;
    private Tree operateTree;
    private int size;

    public Solution1622() {
        this.data = new int[100000];
        this.operateTree = new Tree();
        this.size = 0;
    }

    public void append(int val) {
        this.data[size] = val;
        this.size++;
    }

    public void addAll(int inc) {
        operateTree.addOperate(this.size - 1, inc);
    }

    public void multAll(int m) {
        operateTree.addOperate(this.size - 1, -m);
    }

    public int getIndex(int idx) {
        if (idx >= this.size) return -1;
        String operateList = this.operateTree.getOperate(idx, this.size - 1);
        long num = this.data[idx];
        if (Objects.isNull(operateList)) return (int) num;
        for (String operateString : operateList.split(operateTree.splitString)) {
            if (operateTree.isStringEmpty(operateString)) continue;
            long operate = Long.parseLong(operateString);
            if (operate > 0) {
                num = (num + operate) % 1000000007;
            } else {
                num = (num * -operate) % 1000000007;
            }
        }
        return (int) num;
    }



}
