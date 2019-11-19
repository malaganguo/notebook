package com.mlgg.thinkinjava.C9;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @version 1.0<br>
 * @taskId <br>
 * @see com.mlgg.thinkinjava
 * @since v8.0
 */
public class NeverCaught {
    static void f() {
        throw new RuntimeException("From f()");
    }
    static void g() {
        f();
    }
    public static void main(String[] args) {
        g();
    }
}
