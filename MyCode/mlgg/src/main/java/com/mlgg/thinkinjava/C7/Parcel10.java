package com.mlgg.thinkinjava.C7;

/**
 * @author zhang.yifei4
 * @version 1.0
 * @ClassName Parcel10
 * <p>
 * @Date
 * @since v9.0
 */
public class Parcel10 {
    private static class PContents
            extends Contents {
        private int i = 11;
        public int value() { return i; }
    }
    protected static class PDestination
            implements Destination {
        private String label;
        private PDestination(String whereTo) {
            label = whereTo;
        }
        public String readLabel() { return label; }
    }
    public static Destination dest(String s) {
        return new PDestination(s);
    }
    public static Contents cont() {
        return new PContents();
    }
    public static void main(String[] args) {
        Contents c = cont();
        Destination d = dest("Tanzania");
    }
}

abstract class Contents {
    abstract public int value();
}
interface Destination {
    String readLabel();
}
