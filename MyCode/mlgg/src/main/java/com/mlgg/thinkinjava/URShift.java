package com.mlgg.thinkinjava;

/**
 * @author zhang.yifei4
 * @version 1.0
 * @ClassName URShift
 * <p>
 * @Date
 * @since v9.0
 */
public class URShift {
    public static void main(String[] args) {
        int i = -1;
        i>>>=1000;
        System.out.println(i);
        int j = -1;
        j>>>=8;
        System.out.println(j);
    }
}
