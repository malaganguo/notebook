package com.mlgg.thinkinjava.C7;

/**
 * @author zhang.yifei4
 * @version 1.0
 * @ClassName Music
 * <p>
 * @Date
 * @since v9.0
 */

public class Music {
    public static void tune(Instrument1 i) {
// ...
        i.play(Note.middleC);
    }
    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute); // Upcasting
    }
}
class Note {
    private int value;
    private Note(int val) { value = val; }
    public static final Note
            middleC = new Note(0),
            cSharp = new Note(1),
            cFlat = new Note(2);
} // Etc.
class Instrument1 {
    public void play(Note n) {
        System.out.println("Instrument.play()");
    }
}
// Wind objects are instruments
// because they have the same interface:
class Wind extends Instrument1 {
    // Redefine interface method:
    public void play(Note n) {
        System.out.println("Wind.play()");
    }
}
/*
* Instrument.play()
* Wind.play()
* 1
* */

/*
* Wind.play()
*
* */