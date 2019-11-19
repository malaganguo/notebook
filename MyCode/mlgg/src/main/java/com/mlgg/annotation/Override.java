package com.mlgg.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 元注解 Target Retention
 * 元注解一般用来某个注解的生命周期以及作用目标信息。
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}
