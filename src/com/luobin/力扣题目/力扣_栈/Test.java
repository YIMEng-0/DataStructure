package com.luobin.力扣题目.力扣_栈;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/10/14 10:44 下午
 */

import java.util.Scanner;

public class Test {
    public static double f(String s) {
        double p = 0;
        //百分比计算
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '%') {
                for (int j = i - 1; j >= 0; j--) {
                    if (s.charAt(j) == '+' || s.charAt(j) == '-' || s.charAt(j) == '*' || s.charAt(j) == '/') {
                        String s1 = s.substring(j + 1, i);
                        double num = Double.parseDouble(s1) * 0.01;
                        s = s.replace(s.substring(j + 1, i + 1), num + "");
                        break;
                    }
                    if (j == 0) {
                        String s1 = s.substring(j, i);
                        double num = Double.parseDouble(s1) * 0.01;
                        s = s.replace(s.substring(j, i + 1), num + "");
                        break;
                    }
                }
            }
        }

        //乘除计算
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                double num1 = 0, num2 = 0;
                int len1 = 0, len2 = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (s.charAt(j) == '+' || s.charAt(j) == '-') {
                        String s1 = s.substring(j + 1, i);
                        num1 = Double.parseDouble(s1);
                        len1 = s1.length();
                        break;
                    }
                    if (j == 0) {
                        String s1 = s.substring(j, i);
                        num1 = Double.parseDouble(s1);
                        len1 = s1.length();
                        break;
                    }
                }
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == '+' || s.charAt(j) == '-' || s.charAt(j) == '*' || s.charAt(j) == '/') {
                        String s1 = s.substring(i + 1, j);

                        num2 = Double.parseDouble(s1);
                        len2 = s1.length();
                        break;
                    }
                    if (j == s.length() - 1) {
                        String s1 = s.substring(i + 1, j + 1);
                        num2 = Double.parseDouble(s1);
                        len2 = s1.length();
                        break;
                    }
                }
                if (s.charAt(i) == '*') {
                    double res = num1 * num2;
                    String s2 = s.substring(i - len1, i + len2 + 1);
                    String s3 = res + "";
                    s = s.replace(s2, s3);
                    i = i - len1 - 1 + s3.length();
                    continue;
                }
                if (s.charAt(i) == '/') {
                    double res = num1 / num2;
                    String s2 = s.substring(i - len1, i + len2 + 1);
                    String s3 = res + "";
                    s = s.replace(s2, s3);
                    i = i - len1 - 1 + s3.length();
                    continue;
                }

            }
        }

        //加减计算
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                double num1 = 0, num2 = 0;
                int len1 = 0, len2 = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (j == 0) {
                        String s1 = s.substring(j, i);
                        num1 = Double.parseDouble(s1);
                        len1 = s1.length();
                        break;
                    }
                }
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == '+' || s.charAt(j) == '-') {
                        String s1 = s.substring(i + 1, j);
                        num2 = Double.parseDouble(s1);
                        len2 = s1.length();
                        break;
                    }
                    if (j == s.length() - 1) {
                        String s1 = s.substring(i + 1, j + 1);
                        num2 = Double.parseDouble(s1);
                        len2 = s1.length();
                        break;
                    }
                }
                if (s.charAt(i) == '+') {
                    double res = num1 + num2;
                    String s2 = s.substring(i - len1, i + len2 + 1);
                    String s3 = res + "";
                    s = s.replace(s2, s3);
                    i = i - len1 - 1 + s3.length();
                    continue;
                }
                if (s.charAt(i) == '-') {
                    double res = num1 - num2;
                    String s2 = s.substring(i - len1, i + len2 + 1);
                    String s3 = res + "";
                    s = s.replace(s2, s3);
                    i = i - len1 - 1 + s3.length();
                    continue;
                }
            }
        }
        return Double.parseDouble(s);
    }

    //   50%*4+200%*2-4/50%+100%/2/50%*200%+500*0.1%  0.5
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        double num = f(s);
        System.out.println(num);
    }
}