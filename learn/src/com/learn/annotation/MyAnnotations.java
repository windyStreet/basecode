package com.learn.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;


/**
 * @author windyStreet
 * @codetime 2021-03-31 16:03
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, CONSTRUCTOR, FIELD, METHOD, PARAMETER, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotations {
    MyAnnotation[] value();
}
