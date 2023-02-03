package com.wjcat.learn.leetcode;

public class Solution1622Temp extends Solution1622 {

    //模ε=(´ο｀*)))唉
    private int mod = 1000000007;

    //序列序号
    private int valIndex = 0;

    //操作序号
    private int opIndex = 0;

    //当前值数组
    private int[] vals = new int[100001];

    //操作号数组
    private int[] opIds = new int[100001];

    //操作值数组
    private int[] opNums = new int[100001];

    //操作符数组
    private char[] opTypes = new char[100001];

    public Solution1622Temp() {

    }

    /**
     * 直接插入当前值数组，并将当前操作序号插入操作号数组
     */
    @Override
    public void append(int val) {
        this.vals[this.valIndex] = val;
        this.opIds[this.valIndex] = this.opIndex;
        this.valIndex++;
    }

    /**
     * 直接插入操作值和操作符数组
     */
    @Override
    public void addAll(int inc) {
        this.opTypes[this.opIndex] = '+';
        this.opNums[this.opIndex] = inc;
        this.opIndex++;
    }

    /**
     * 直接插入操作值和操作符数组
     */
    @Override
    public void multAll(int m) {
        this.opTypes[this.opIndex] = '*';
        this.opNums[this.opIndex] = m;
        this.opIndex++;
    }

    /**
     * 调用此方法时对结果进行计算，更新当前值，更新操作号
     */
    @Override
    public int getIndex(int idx) {
        if (idx < this.valIndex) {
            //long类型避免溢出
            long val = this.vals[idx];
            //将要进行操作的序号
            int index = this.opIds[idx];
            //循环操作
            for (int i = index; i < this.opIndex; i++) {
                char type = this.opTypes[i];
                int num = this.opNums[i];
                switch (type) {
                    case '+':
                        val += num;
                        break;
                    case '*':
                        val *= num;
                        break;
                }
                val %= mod;
            }
            //更新当前值
            this.vals[idx] = (int) val;
            //更新操作号
            this.opIds[idx] = this.opIndex;
            return (int) val;
        }
        return -1;
    }

}
