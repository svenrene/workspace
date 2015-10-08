package wbs.reflection_annotation;

import java.lang.reflect.Method;

public class MethodDemo {

	
	public static void main(String[] args) throws Exception {

		Class<Buch> cls = Buch.class;

		Buch buch = cls.newInstance();

		buch.setAutor("Lin Yutang");
		buch.setTitel("The importance of living");
		buch.setIsbn("0-688-16352-1");
		buch.setPreis(12.3);
		
		System.out.println(buch);

		Method method = cls.getMethod("setPreis", Double.TYPE);
		method.invoke(buch, Double.valueOf(13.2));

		System.out.println(buch);
	}
}
