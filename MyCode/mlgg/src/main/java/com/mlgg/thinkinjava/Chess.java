package com.mlgg.thinkinjava;

/**
 * @author zhang.yifei4
 * @version 1.0
 * @ClassName Game
 * <p>
 * @Date
 * @since v9.0
 */
class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}
class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}
public class Chess extends BoardGame {
    Chess() {
        super(11);
        System.out.println("Chess constructor");
    }
    public static void main(String[] args) {
        Chess x = new Chess();
    }
}
