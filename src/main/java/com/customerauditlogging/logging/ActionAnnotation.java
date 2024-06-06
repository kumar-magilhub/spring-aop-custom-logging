package com.customerauditlogging.logging;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionAnnotation {
    String typeOfAction() default "null";

    String typeOfModule() default "null";

    String comment() default "null";
}
