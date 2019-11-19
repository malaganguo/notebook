package com.mlgg.c2.bean;


import org.springframework.beans.factory.annotation.Autowired;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 9:57 2019/10/29
 * @see com.mlgg.c2.bean
 */
public class Phone {

    private String name = "iphone xr 64G";

    private int price = 4500;

    private Battery battery = new Battery();

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
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", battery=" + battery +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
