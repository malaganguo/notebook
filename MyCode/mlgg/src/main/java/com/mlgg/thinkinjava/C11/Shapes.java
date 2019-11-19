package com.mlgg.thinkinjava.C11;

import java.util.Enumeration;
import java.util.Vector;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 15:40 2019/11/2
 * @see com.mlgg.thinkinjava.C11
 */
public class Shapes {
    public static void main(String[] args) {
        Vector s = new Vector();
        s.addElement(new Circle());
        s.addElement(new Square());
        s.addElement(new Triangle());
        Enumeration e = s.elements();
        while(e.hasMoreElements())
            ((Shape)e.nextElement()).draw();
    }
}
interface Shape {
    void draw();
}
class Circle implements Shape {
    public void draw() {
        System.out.println("Circle.draw()");
    }
}
class Square implements Shape {
    public void draw() {
        System.out.println("Square.draw()");
    }
}
class Triangle implements Shape {
    public void draw() {
        System.out.println("Triangle.draw()");
    }
}