package wbs.reflection_annotation;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class PersistenceManager {

	// TODO ggf fehlerhandling (kein primary key,...) später einbauen
	public String class2Table(String className,
			Map<String, String> tableMappings, Map<String, String> typeMappings)
			throws ClassNotFoundException {
		
		StringBuffer sqlstmt = new StringBuffer();
		
		
		Class<?> clazz = Class.forName(className);
		PrimaryKey primaryKey;
		
		SortedMap<Integer, String> primaryKeys = new TreeMap<Integer, String>();
		sqlstmt.append("create table ");
		sqlstmt.append(tableMappings.get(className));
		sqlstmt.append(" (");
		for (Field field : clazz.getDeclaredFields()) {
			if (field.getAnnotation(Column.class) != null) {
				sqlstmt.append(field.getName() + " "
						+ typeMappings.get(field.getType().getSimpleName())
						+ ",");
			}
			if ((primaryKey = field.getAnnotation(PrimaryKey.class)) != null) {
				
				primaryKeys.put(primaryKey.index(), field.getName());
			}
		}

		sqlstmt.append("primary key(");
		for (int i : primaryKeys.keySet()) {
			sqlstmt.append(primaryKeys.get(i));
			if (i < primaryKeys.size()) {
				sqlstmt.append(",");
			}
		}
		sqlstmt.append("))");

		return sqlstmt.toString();
	}
}
