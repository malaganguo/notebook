package com.mlgg.thinkinjava;

/**
 * 向上塑形
 * @author zhang.yifei4
 * @version 1.0
 * @ClassName Wind
 * <p>
 * @Date
 * @since v9.0
 */
public class Wind extends Instrument{
    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute); // Upcasting
    }
}
class Instrument {
    public void play() {}
    static void tune(Instrument i) {
// ...
        i.play();
    }
}