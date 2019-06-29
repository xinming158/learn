package com.xinming;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */

public class Q29 {
    public static void main(String[] args) {
        Q29 q29 = new Q29();
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        q29.findNumsAppearOnce(new int[]{1, 2, 3, 4, 5, 7, 7, 4, 2, 1}, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        for (int i = 0; i < array.length; i++) {
            boolean single = true;
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    single = false;
                    break;
                }
            }
            if (single) {
                if (num1[0] == 0) {
                    num1[0] = array[i];
                } else if (num2[0] == 0) {
                    num2[0] = array[i];
                } else {
                    break;
                }
            }
        }
    }
}
