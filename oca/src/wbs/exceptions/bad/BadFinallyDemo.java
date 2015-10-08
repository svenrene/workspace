package wbs.exceptions.bad;

public class BadFinallyDemo {

	public static void main(String[] args) throws Exception{

		
		try{
			int i = Integer.parseInt("blabla");
			throw new Exception();
		}
		finally{
			System.out.println("finally");
			
		}
		return;

	}

}
