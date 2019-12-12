package com.mlgg.effective;

import java.util.Objects;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 15:44 2019/12/12
 * @see com.mlgg.effective
 */
public class PizzaNy extends Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;
    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public PizzaNy build() {
            return new PizzaNy(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
    PizzaNy(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override
    public String toString() {
        return "PizzaNy{" +
                "size=" + size +
                ", toppings=" + toppings +
                '}';
    }
}
