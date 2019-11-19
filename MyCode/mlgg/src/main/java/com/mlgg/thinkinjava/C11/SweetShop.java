package com.mlgg.thinkinjava.C11;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 15:54 2019/11/2
 * @see com.mlgg.thinkinjava.C11
 */
public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("com.mlgg.thinkinjava.C11.Gum");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(
                "After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}
class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}
class Gum {
    static {
        System.out.println("Loading Gum");
    }
}