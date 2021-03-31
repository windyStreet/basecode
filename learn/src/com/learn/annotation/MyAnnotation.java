package com.learn.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author windyStreet
 * @codetime 2021-03-31 15:34
 */

@Repeatable(MyAnnotations.class)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, CONSTRUCTOR, FIELD, METHOD, PARAMETER, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {
    //    String value();
    String value() default "你好啊";
}
