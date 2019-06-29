package com.xinming;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 */
public class Q5 {

    public static void main(String[] args) {
        Q5 q5 = new Q5();
        int value = q5.sum(5, 7);
        System.out.println(value);
    }

    public int sum(int num1, int num2) {
        while (num2 != 0) {
            // 计算个位
            int temp = num1 ^ num2;
            // 计算进位（1+1）
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
