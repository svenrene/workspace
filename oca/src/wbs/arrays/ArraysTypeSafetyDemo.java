package wbs.arrays;

public class ArraysTypeSafetyDemo {

	public static void main(String[] args) {

		String[] sa = { "eins", "zwei", "drei" };

		Object[] oa;
		
		// oa und sa referenzieren nach der zuweisung beide dasselbe array
		// für oa ist aber der elementtyp object, und für sa ist der elementtyp string
		oa = sa;
		
		// da oa[0] und sa[0] dieselbe speicherstelle referenzieren, würde der nachstehende
		// code in ein string- array eine integer-referenz "einschmuggeln"
		
		// es gibt eine ArrayStoreException
		oa[0] = Integer.valueOf(10);
		
		
//		oa[0] = "zwei";
//		for (String s : sa) {
//			System.out.println(s);
//		}
		
	}

}
