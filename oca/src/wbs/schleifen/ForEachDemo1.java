package wbs.schleifen;

public class ForEachDemo1 {

	public static void main(String[] args) {
		
		
//		// ausgabe aller aufrufargumente mit foreach
//		for (String s : args) {
//			System.out.println(s);
//		}
		
		// ausgabe aller aufrufargumente mit for
		for( int i = 0 ; i < args.length ; i++ )	{
			System.out.println(args[i]);
			}		
	
	}

}
