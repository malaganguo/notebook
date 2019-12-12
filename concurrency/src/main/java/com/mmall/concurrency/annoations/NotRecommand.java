package com.mmall.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 不推荐写法的类
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)//编译时忽略
public @interface NotRecommand {

    String value() default "";
}
