package wbs.basic_data_types;

public class EqualsDemo {

	public static void main(String[] args) {

		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);
		
		// == testet auf identität
		// es wird also überprüft, ob i1 und i2 dasselbe objekt referenzieren
		
		System.out.println(i1 == i2); // false 
		
		// in der klasse Integer führt die methode equals() einen wertmässigen
		// vergleich durch, und nicht einen referenzvergleich
		
		// die klasse Integer überschreibt die methode equals() von Object
		System.out.println(i1.equals(i2)); // true 
		
		// --------------------------------
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		
		System.out.println(sb1 == sb2); // false
		
		// in der klasse StringBuffer führt die methode equals() keinen wertmässigen
		// vergleich durch, sondern einen referenzvergleich
		
		// die klasse StringBuffer überschreibt die methode equals() von Object nicht
		System.out.println(sb1.equals(sb2)); // false 
		
		// --------------------------------
		String s1 = "abc";
		String s2 = "abc";
		
		// die klasse String überschreibt die methode equals()
		System.out.println(s1 == s2);		// true
		System.out.println(s1.equals(s2));	// true
		
	}

}
