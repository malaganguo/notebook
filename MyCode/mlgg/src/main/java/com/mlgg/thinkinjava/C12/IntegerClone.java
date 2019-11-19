package com.mlgg.thinkinjava.C12;

import java.util.ArrayList;
import java.util.Vector;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 17:28 2019/11/4
 * @see com.mlgg.thinkinjava.C12
 */
public class IntegerClone {
    public static void main(String[] args) {
        Integer integer = new Integer(1);
        String s = new String();
        StringBuffer stringBuffer = new StringBuffer();
        Thread thread = new Thread();
        Object o = new Object();

        ArrayList<Object> objects = new ArrayList<>();
        int[] ints = new int[1];
        float[] f = new float[1];

        f.clone();
        ints.clone();
        objects.clone();
    }
}
