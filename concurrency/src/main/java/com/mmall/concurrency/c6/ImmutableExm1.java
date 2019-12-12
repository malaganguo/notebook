package com.mmall.concurrency.c6;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

/**
 * guava提供的集合可以实现线程安全
 */
public class ImmutableExm1 {
    private static final Integer a = 1;
    private static final String b = "2";
    private static final Map<Integer, Integer> map = Maps.newHashMap();
    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
//        map = Collections.unmodifiableMap(map);//让map集合内容不可变
    }

    public static void main(String[] args) {
//        a=2;
//        b = "3";
//       map = Maps.newHashMap();
        map.put(7,8);

    }
}
