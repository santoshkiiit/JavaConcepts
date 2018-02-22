package com.learning.annotation.implementation;


import java.lang.annotation.*;


/**
 * Created by santoshk on 2/15/18.
 */
@Documented
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDate {

    Class<? extends Object> type();
}
