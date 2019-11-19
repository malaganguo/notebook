package com.mlgg.work;

import org.junit.Test;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 11:22 2019/11/13
 * @see com.mlgg.work
 */
public class Tests {

    protected String value = "a";//同包访问
    @Test
    public void test1() {
        String s = "1;aa;2;bb";
        System.out.println(s.split("\\;")[3]);
    }
}


