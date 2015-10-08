package wbs.misc;


class M{
	
//	int a;
//	static int f()
//	{
//		return a;
//	}
	
}

class N {

	
	private M m = new M();
	public void makeItNull(M pM){
		//System.out.println(pM);
		pM = null;
	}
	
	public void makeThisNull(){
		makeItNull(m);
	}
	
	
	public static void main(String[] args) {
		N n = new N ();
		n.makeThisNull();
	}

}
