package com.mlgg.algorithm.leetcode;

/**
 * @author zhang.yifei4
 * @version 1.0
 * @ClassName 回文数
 * <p>
 * @Date
 * @since v9.0
 */
public class 回文数 {
    public boolean isPalindrome(int x) {
        String strX = String.valueOf(x);
        char[] chars = strX.toCharArray();
        int mid =  strX.length() / 2;
        for(int i = 0;i<mid;i++){
            if(chars[i] != chars[strX.length()-i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        回文数 回文数 = new 回文数();
        boolean palindrome = 回文数.isPalindrome(2332332);
        System.out.println(palindrome);
        double v = Double.parseDouble("123.0100");
        System.out.println(v);
        int v1 =(int)v;
    }
}

