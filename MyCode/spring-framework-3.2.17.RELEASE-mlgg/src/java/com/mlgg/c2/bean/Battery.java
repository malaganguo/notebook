package com.mlgg.c2.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 9:58 2019/10/29
 * @see com.mlgg.c2.bean
 */
public class Battery implements BeanFactoryAware{

    private int capacity = 2000;

    private String brand = "apple";

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Battery{" +
                "capacity=" + capacity +
                ", brand='" + brand + '\'' +
                '}';
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}
