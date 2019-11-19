package com.mlgg.thinkinjava.C9;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @version 1.0<br>
 * @taskId <br>
 * @see com.mlgg.thinkinjava.C9
 * @since v8.0
 */
public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }
    public static void main(String[] args) throws Exception {
        LostMessage lm = new LostMessage();
        try {
            lm.f();
        } finally {
            lm.dispose();
        }
    }
}
class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }
}
class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}
