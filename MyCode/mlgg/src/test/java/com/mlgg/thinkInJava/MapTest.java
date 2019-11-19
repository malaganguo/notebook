package com.mlgg.thinkInJava;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @version 1.0<br>
 * @taskId <br>
 * @since v8.0
 */
public class MapTest {

    @Test
    public void mapPerformance() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        Hashtable<Object, Object> hashtable = new Hashtable<>();

        long hashMapStart = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            hashMap.put(i,i*i);
        }
        long hashMapEnd = System.currentTimeMillis();
        System.out.println("hashMap:"+(hashMapEnd-hashMapStart));

        long treeMapStart = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            treeMap.put(i,i*i);
        }
        long treeMapEnd = System.currentTimeMillis();
        System.out.println("treeMap:"+(treeMapEnd-treeMapStart));

        long hashtableStart = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            hashtable.put(i,i*i);
        }
        long hashtableEnd = System.currentTimeMillis();
        System.out.println("hashtable:"+(hashtableEnd-hashtableStart));

        System.out.println("---------------------");
        get(hashMap, treeMap, hashtable);
    }

    public static void get(HashMap<Object, Object> hashMap, TreeMap<Object, Object> treeMap, Hashtable<Object, Object> hashtable) {
        long hashMapStart = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            hashMap.get(i);
        }
        long hashMapEnd = System.currentTimeMillis();
        System.out.println("hashMap:"+(hashMapEnd-hashMapStart));

        long treeMapStart = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            treeMap.get(i);
        }
        long treeMapEnd = System.currentTimeMillis();
        System.out.println("treeMap:"+(treeMapEnd-treeMapStart));

        long hashtableStart = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            hashtable.get(i);
        }
        long hashtableEnd = System.currentTimeMillis();
        System.out.println("hashtable:"+(hashtableEnd-hashtableStart));
    }
}

/* hashMap:10
   treeMap:22
   hashtable:25
   ---------------------
   hashMap:5
   treeMap:9
   hashtable:5*/
