package com.mlgg.effective;

import org.junit.jupiter.api.Test;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 11:15 2019/12/12
 * @see com.mlgg.effective
 */

public class TestDemo {
    public static void main(String[] args) {
        final Student instance = Student.getInstance();
        instance.play();
    }

}
