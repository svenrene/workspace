package wbs.reflection_annotation;

import java.lang.reflect.Field;

public class FieldDemo {

	
	public static void main(String[] args) throws Exception {
		
		Class<?> cls = Class.forName("wbs.reflection_annotation.Buch");
		Object o = cls.newInstance();
		
		Field field = cls.getDeclaredField("isbn");
		field.setAccessible(true);
		field.set(o, "0-688-16352-1");
		
		field = cls.getDeclaredField("autor");
		field.setAccessible(true);
		field.set(o, "Lin Yutang");
		
		field = cls.getDeclaredField("titel");
		field.setAccessible(true);
		field.set(o, "The importance of living");
		
		field = cls.getDeclaredField("preis");
		field.setAccessible(true);
		field.set(o, Double.valueOf(12.3));
		
		System.out.println(o);
	}

}
