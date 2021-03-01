package com.qyfei;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface RequestInfo {

    InfoType InfoType() default InfoType.info;

    StyleType StyleType() default StyleType.text;

    String ShowName();

    int Order() default 0;

    String Style() default "";

    String ContentStyle() default "";

    String AddText() default "";

    String SkipValue() default "";
}
