package com.cyb.test.mytest.aop.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;


/**
 * Created by pc on 2017/9/16.
 */
@Target(METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface NetCheck {
}
