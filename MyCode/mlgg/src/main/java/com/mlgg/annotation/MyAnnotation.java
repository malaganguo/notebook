package com.mlgg.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <Description> 只可添加在成员字段上<br>
 *
 * @author zhang.yifei4<br>
 * @Date 10:11 2019/11/12
 * @see com.mlgg.annotation
 */
@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited //子类自动继承父类的这个注解
public @interface MyAnnotation {
}
