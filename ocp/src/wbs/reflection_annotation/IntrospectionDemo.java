package wbs.reflection_annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class IntrospectionDemo {

	public static void main(String[] args) {
		String className = args[0];
		Class<?> cls = null;
		try {
			cls = Class.forName(className);
			System.out.println(cls.getName());

			System.out.println(cls.getSuperclass().getName());

			for (Class<?> myIf : cls.getInterfaces()) {
				System.out.println(myIf.getName());
			}

			for (Constructor<?> constructor : cls.getConstructors()) {
				System.out.println(constructor);
			}

			for (Field field : cls.getFields()) {
				System.out.println(field);
			}

			for (Field field : cls.getDeclaredFields()) {
				System.out.println(field);
			}

			System.out.println("------------");
			for (Method method : cls.getMethods()) {
				System.out.println(method);
			}

			System.out.println("------------");
			for (Method method : cls.getDeclaredMethods()) {
				System.out.println(method);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
