package com.mlgg.effective;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 11:13 2019/12/12
 * @see com.mlgg.effective
 */
public class Student {

    public static Student getInstance() {
        return new Student();
    }

    public void play() {
        System.out.println("play");
    }
}
