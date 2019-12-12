package com.mlgg.effective;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 15:09 2019/12/12
 * @see com.mlgg.effective
 */
public abstract class Pizza {
    public enum Topping { HAM , MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }
        abstract Pizza build();

        protected abstract T self();
    }
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
