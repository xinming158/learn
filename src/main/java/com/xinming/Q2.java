package com.xinming;

/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Q2 {
    public String replace(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }
        StringBuilder replaceString = new StringBuilder();
        char[] chars = string.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                replaceString.append("%20");
            } else {
                replaceString.append(c);
            }
        }
        return replaceString.toString();
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        String string = q2.replace("We Are Happy");
        System.out.println(string);
    }
}
