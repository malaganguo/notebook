package com.mlgg.thinkinjava;

/**
 * 打印的结果？
 * @author zhang.yifei4
 * @version 1.0
 * @ClassName Beetle
 * <p>
 * @Date
 * @since v9.0
 */
public class Beetle extends Insect{
    int k = prt("Beetle.k initialized");
    Beetle() {
        prt("k = " + k);
        prt("j = " + j);
    }
    static int x2 =
            prt("static Beetle.x2 initialized");
    static int prt(String s) {
        System.out.println(s);
        return 63;
    }
    public static void main(String[] args) {
        prt("Beetle constructor");
        Beetle b = new Beetle();
    }

}
class Insect {
    int i = 9;
    int j;
    Insect() {
        prt("i = " + i + ", j = " + j);
        j = 39;
    }
    static int x1 =
            prt("static Insect.x1 initialized");
    static int prt(String s) {
        System.out.println(s);
        return 47;
    }
}
/*
* 我的思路：静态常量->构造方法
* static Insect.x1 initialized   1
* static Beetle.x2 initialized   2
* i = 9, j = 0                   4
* Beetle.k initialized           5
* k = 63                         6
* j = 49                         7
* Beetle constructor             3
*
* 错误原因：程序的入口是main方法，创建对象的时候才执行构造方法，静态资源在程序启动时加载完毕。
*
*
* 执行顺序：
*   1. 装载程序找到最外面的类，有父类优先加载父类
*   2. 在根父类执行静态初始化，下一个执行其子类的静态初始化，以此类推
*   3. 类装载完毕，可以创建对象了，创建对象，首先执行构造方法，构造方法中默许执行super(),即首先加载父类的构造方法，以此类推
*   4. 实际变量按照本来的顺序初始化
* */