package wbs.reflection_annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorDemo {

	public static void main(String[] args) {
		
		try {
			String className = "wbs.reflection_annotation.Buch";
			Class<?> cls = Class.forName(className);
			Object o = cls.newInstance();
			System.out.println(o);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		}

		
		try {
			String className = "wbs.reflection_annotation.Buch";

			String isbn = "0-688-16352-1";
			String autor = "Lin Yutang";
			String titel = "The importance of living";
			double preis = 12.30;

			Class<?> cls = Class.forName(className);

			Constructor<?> constructor = cls.getConstructor(String.class,
					String.class, String.class, Double.TYPE);

			Object o = constructor.newInstance(isbn, autor, titel, preis);
			
			System.out.println(o);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
