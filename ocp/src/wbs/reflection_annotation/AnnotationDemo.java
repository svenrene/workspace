package wbs.reflection_annotation;

import java.lang.reflect.Field;

public class AnnotationDemo {

	public static void main(String[] args) {

		Class<Buch> cls = Buch.class;

		Column column;
		PrimaryKey primaryKey;

		// wir iterieren über alle felder der klasse
		for (Field field : cls.getDeclaredFields()) {
			column = field.getAnnotation(Column.class);
			if (column != null) {
				System.out.println(field.getName() + " -> "
						+ field.getType().getSimpleName());
				primaryKey = field.getAnnotation(PrimaryKey.class);
				if (primaryKey != null) {
					System.out.println(field.getName()
							+ " is column in primary key at index : "
							+ primaryKey.index());
				}
			}
		}
	}
}
