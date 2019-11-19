package com.mlgg.thinkinjava;

/**
 * @author zhang.yifei4
 * @version 1.0
 * @ClassName Scope
 * <p>
 * @Date
 * @since v9.0
 */
public class Scope {

    public static void main(String[] args) {
        int i = 1;

        String s = new String("s");
        {
            String a = new String("a");
            String b = "b";
            b += a;
            System.out.println(b);
            int c;
            //System.gc();

            //int i = 2;//Variable 'i' is already defined in the scope
        }
        int b;
        System.out.println(i);
    }
}
