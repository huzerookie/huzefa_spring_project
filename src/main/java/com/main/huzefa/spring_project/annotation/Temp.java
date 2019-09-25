package com.main.huzefa.spring_project.annotation;

import java.lang.annotation.Annotation;

@MyAnnotation(value = 101,stringVal = "Huzefa Class Modified")
public class Temp{
	
	@MyAnnotation(intValue = 10000, value = 1000000)
	public void mAnnotation() {
		
	}
	
	public void m1() {
		Annotation[] a = (Annotation[]) this.getClass().getAnnotations();
		for(Annotation a1:a) {
			System.out.println(a1);
		}
		
		MyAnnotation myan = this.getClass().getAnnotation(MyAnnotation.class);
		System.out.println(myan.intValue()+"    "+myan.stringVal());
		
		
		
		
	}
	public static void main(String args[]) {
		new Temp().m1();
		
	}
	
}
