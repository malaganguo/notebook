package com.mlgg.thinkinjava.C12;

import com.mlgg.thinkinjava.C12.protectedKW.Protected;
import com.mlgg.thinkinjava.C12.protectedKW.ProtectedTest1;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 10:04 2019/11/5
 * @see com.mlgg.thinkinjava.C12
 */
public class ProtectTest2 {
    public static void main(String[] args) {
        Protected aProtected = new Protected();
        //aProtected无法访问任何任何Protected类的成员   包括继承自Object类的clone()方法
//        System.out.println(aProtected.a);


    }
}
