package wbs.reflection_annotation;

import java.util.HashMap;
import java.util.Map;

public class PersistenceManagerDemo {

	public static void main(String[] args) throws Exception {
		
		PersistenceManager pm = new PersistenceManager();
				
		Map<String, String> tableMappings = new HashMap<String, String>();
		Map<String, String> typeMappings = new HashMap<String, String>();
		
		String sql;
		
		tableMappings.put("wbs.reflection_annotation.Buch", "Buch");
		
		typeMappings.put("int", "integer");
		typeMappings.put("String", "varchar(255)");
		typeMappings.put("double", "decimal(8,2)");
				
		sql = pm.class2Table("wbs.reflection_annotation.Buch", tableMappings, typeMappings);
		
		System.out.println(sql);
	}
}
