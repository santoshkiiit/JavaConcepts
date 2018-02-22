package com.learning.annotation.implementation;

import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by santoshk on 2/15/18.
 *
 *
 */

@Documented
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPanNumber  {


    String type();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
