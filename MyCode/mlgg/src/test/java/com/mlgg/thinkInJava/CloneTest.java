package com.mlgg.thinkInJava;

import com.mlgg.thinkInJava.entity.NoImplCloneableEntity;
import com.mlgg.thinkInJava.entity.Phone;
import org.junit.Test;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 13:45 2019/11/6
 * @see com.mlgg.thinkInJava
 */
public class CloneTest {

    //能克隆不仅要覆写clone方法为public，还要给接口实现Cloneable接口,否则会抛出CloneNotSupportedException
    @Test
    public void test1() throws CloneNotSupportedException {
        new Phone().clone();
        new NoImplCloneableEntity().clone();
    }

    /**
     * clone的对象还是以前的对象吗？
     *   不是同一个对象，不会对原对象产生任何副作用
     *   引用传递的“复制”其实还是同一个对象
     * @throws CloneNotSupportedException
     */
    @Test
    public void test2() throws CloneNotSupportedException {
        Phone phone = new Phone();
        Phone clonePhone = (Phone) phone.clone();
        System.out.println(phone == clonePhone);//false
        System.out.println(phone.getName().equals(clonePhone.getName()));//true
    }

}

