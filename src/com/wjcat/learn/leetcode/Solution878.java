package com.wjcat.learn.leetcode;

public class Solution878 {

    public static void main(String[] args) {
        Solution878 solution878 = new Solution878();
//        System.out.println(solution878.nthMagicalNumber(1, 2, 3));
//        System.out.println(solution878.nthMagicalNumber(4, 2, 3));
//        System.out.println(solution878.nthMagicalNumber(100, 11, 20));
//        System.out.println(solution878.nthMagicalNumber(5, 2, 4));
//        System.out.println(solution878.nthMagicalNumber2(3, 8, 3));
//        System.out.println(solution878.nthMagicalNumber2(4, 2, 3));
//        System.out.println(solution878.nthMagicalNumber2(5, 2, 4));
//        System.out.println(solution878.nthMagicalNumber2(1000000000, 39999, 40000));
        System.out.println(solution878.nthMagicalNumber2(887859796, 29911, 37516));
    }


    static final int MOD = 1000000007;

    public int nthMagicalNumber(int n, int a, int b) {
        long l = Math.min(a, b);
        long r = (long) n * Math.min(a, b);
        int c = lcm(a, b);
        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = mid / a + mid / b - mid / c;
            if (cnt >= n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ((r + 1) % MOD);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public int nthMagicalNumber2(int n, int a, int b) {
        long gcd = gcd(a, b);

        long aNum = a / gcd;
        long bNum = b / gcd;
        long len = aNum + bNum - 1;
        long lcm = (long) a * b / gcd;

        long mantissa = n % len;
        long cycle = n / len;

        long complementA = (mantissa * bNum / (aNum + bNum) + 1) * a;
        long complementB = (mantissa * aNum / (aNum + bNum) + 1) * b;
        long complement = mantissa == 0 ? 0 : Math.min(complementA, complementB);
        return (int) ((cycle * lcm + complement) % 1000000007);
    }

}
