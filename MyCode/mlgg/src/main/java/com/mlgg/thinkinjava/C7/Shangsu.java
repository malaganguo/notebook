package com.mlgg.thinkinjava.C7;

/**
 * @author zhang.yifei4
 * @version 1.0
 * @ClassName Shangsu
 * <p>
 * @Date
 * @since v9.0
 */
public class Shangsu {
    public static void main(String[] args) {
        Father f = new Son();
        System.out.println(f.age);
        f.hello();
        f.say();
        //上溯将会丢弃子类自己的成员
        //下溯找回丢失的成员
        Son f1 = (Son) f;
        System.out.println(f1.s);
        f1.speak();
    }
}

abstract class Father {
    public abstract void say();
    public int age = 23;
    public void hello(){
        System.out.println("hello");
    }
}
class Son extends Father {
    public int s = 22;

    @Override
    public void say() {
        System.out.println("father");
    }
    public void speak(){
        System.out.println("son");
    }
}