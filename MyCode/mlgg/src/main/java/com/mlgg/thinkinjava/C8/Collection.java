package com.mlgg.thinkinjava.C8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhang.yifei4
 * @version 1.0
 * @ClassName Collection
 * <p>
 * @Date
 * @since v9.0
 */
public class Collection {
    public static void main(String[] args) {
        Dog wangwang = new Dog("wangwang", 2);
        Cat cat = new Cat();
        List list = new ArrayList();
        list.add(cat);
        list.add(wangwang);

        Iterator objectIterator = new Iterator<List>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public List next() {
                return null;
            }
        };
        if(objectIterator.hasNext()) {
            System.out.println(objectIterator.next());
        }

    }
}
class Dog {
    public Dog() {
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Cat {

}
