package wbs.reflection_annotation;

import java.util.Random;

public class ReflectionDemo {

	public static void main(String[] args) {
		
		Random rnd = new Random();
		Class<? extends Random> cls1 = rnd.getClass();
		System.out.println(cls1.getSimpleName());  // Random
		
		Class<?> cls2 = Integer.class;
		System.out.println(cls2.getSimpleName());   // Integer
		
		String className = "wbs.reflection_annotation.Buch";
		
		try {
			Class<?> cls3 = Class.forName(className);
			System.out.println(cls3.getSimpleName());
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		Class<?> cls41 = Boolean.TYPE;
		Class<?> cls42 = boolean.class;
		System.out.println(cls41.getSimpleName());
		System.out.println(cls42.getSimpleName());
	}
}
