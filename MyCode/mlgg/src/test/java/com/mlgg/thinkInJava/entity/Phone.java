package com.mlgg.thinkInJava.entity;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 13:46 2019/11/6
 * @see com.mlgg.thinkInJava.entity
 */
public class Phone implements Cloneable{
    private String name;
    private int price;

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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
