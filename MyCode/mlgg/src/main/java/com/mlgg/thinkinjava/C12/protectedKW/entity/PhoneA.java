package com.mlgg.thinkinjava.C12.protectedKW.entity;

/**
 * <Description> 浅克隆<br>
 *
 * @author zhang.yifei4<br>A
 * @Date 10:49 2019/11/5
 * @see com.mlgg.thinkinjava.C12.protectedKW.entity
 */
public class PhoneA implements Cloneable {

    private String name;
    private int price;
    private Battery battery;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    @Override//浅克隆
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
