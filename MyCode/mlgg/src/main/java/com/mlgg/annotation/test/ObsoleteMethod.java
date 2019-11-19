package com.mlgg.annotation.test;

import java.util.Date;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 10:26 2019/11/12
 * @see com.mlgg.annotation.test
 */
public class ObsoleteMethod {
    @SuppressWarnings(value = "deprecated")
    public static void main(String[] args) {
        Date date = new Date(2018, 7, 11);
    }
}
