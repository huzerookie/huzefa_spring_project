package com.main.huzefa.spring_project.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	
	String stringVal() default "Huzefa Default";
	int intValue() default 100;
	int value();
	
}
