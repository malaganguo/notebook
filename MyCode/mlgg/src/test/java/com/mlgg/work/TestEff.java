package com.mlgg.work;

import com.mlgg.effective.Pizza;
import com.mlgg.effective.PizzaNy;
import com.mlgg.effective.User;
import org.junit.Test;

import static com.mlgg.effective.Pizza.Topping.ONION;
import static com.mlgg.effective.Pizza.Topping.SAUSAGE;
import static com.mlgg.effective.PizzaNy.Size.SMALL;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 14:54 2019/12/12
 * @see com.mlgg.work
 */
public class TestEff {
    @Test
    public void test1() {
        User user = new User.Builder("zyf", "111").age(23).build();
        System.out.println(user.toString());
    }

    /**
     * 类层次结构的build
     */
    @Test
    public void test2() {
        PizzaNy pizzaNy = new PizzaNy.Builder(SMALL).addTopping(ONION).addTopping(SAUSAGE).build();
        System.out.println(pizzaNy.toString());
    }
}
