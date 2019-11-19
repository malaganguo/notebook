package com.mlgg.thinkinjava.C12.protectedKW;

import com.mlgg.thinkinjava.C12.protectedKW.entity.Battery;
import com.mlgg.thinkinjava.C12.protectedKW.entity.PhoneA;
import com.mlgg.thinkinjava.C12.protectedKW.entity.PhoneB;


/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 11:06 2019/11/5
 * @see com.mlgg.thinkinjava.C12.protectedKW
 */
public class CloneTest {


    public static void main(String[] args) throws CloneNotSupportedException {
        PhoneA phoneA = new PhoneA();
        PhoneB phoneB = new PhoneB();
        phoneB.setName("huawei");
        phoneB.setPrice(3999);
        phoneB.setBattery(new Battery("byd",4000));
        PhoneA cloneA = (PhoneA) phoneA.clone();
        PhoneB cloneB = (PhoneB) phoneB.clone();

        System.out.println("浅克隆：克隆的电池等于原电池？"+ (phoneA.getBattery() == cloneA.getBattery()));//true浅克隆的电池句柄指向同一个对象
        System.out.println("深克隆：克隆的电池等于原电池？"+ (phoneB.getBattery() == cloneB.getBattery()));//false深克隆的电池是新创建的对象
    }
}
