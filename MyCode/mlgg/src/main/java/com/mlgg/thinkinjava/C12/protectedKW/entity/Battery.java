package com.mlgg.thinkinjava.C12.protectedKW.entity;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 10:50 2019/11/5
 * @see com.mlgg.thinkinjava.C12.protectedKW.entity
 */
public class Battery implements Cloneable{

    public Battery(String brand, int capacity) {
        this.brand = brand;
        this.capacity = capacity;
    }

    public Battery() {
    }

    private String brand;

    private int capacity;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
