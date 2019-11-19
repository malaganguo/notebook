package com.mlgg.thinkinjava.C12.protectedKW.entity;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 10:53 2019/11/5
 * @see com.mlgg.thinkinjava.C12.protectedKW.entity
 */
public class PhoneB implements Cloneable {
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        PhoneB b = (PhoneB) super.clone();
        b.battery = (Battery) b.battery.clone();
        return b;
    }
}
