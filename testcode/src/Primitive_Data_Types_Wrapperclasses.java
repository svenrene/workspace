
public class Primitive_Data_Types_Wrapperclasses {

	public static void main(String[] args) {

		byte b = 100;
		short s = 200;
		int i = 128;
		long l = 100;
		
		Byte bw = 100;
		Short sw = 200;
		Integer iw = 128;
		Integer iw2 = 128;
		Long lw = 100l;
		
		System.out.println(iw2==iw); // true
//		System.out.println(s==sw); // true
//		
//		System.out.println(i==sw);
		
	//	System.out.println(iw==sw);
		
		System.out.println(iw2.equals(iw)); // 
//		System.out.println(iw.equals(s)); // false
//		System.out.println(lw.equals(b)); // false
		


	}

}
