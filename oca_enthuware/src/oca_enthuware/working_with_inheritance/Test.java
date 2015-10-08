package oca_enthuware.working_with_inheritance;

class Super_{
	  static{ System.out.print("super "); }
	}
	class One{
	  static {  System.out.print("one "); }
	}
	class Two extends Super_{
	  static {  System.out.print("two "); }
	}
	
public class Test{
	  public static void main(String[] args){
	     One o = null;
	     Two t = new Two();
	  }
	}