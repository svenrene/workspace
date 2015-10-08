package wbs.misc;

class Data{
	private int x = 0, y=0;
	public Data(int x, int y){
		this.x = x; this.y = y;
		System.out.println(this.x +" "+ this.y);
	}
	
	public void setValues(int x, int y){
		this.x = x; this.y = y;
		System.out.println(this.x +" "+ this.y);
	}
}

public class TestClass2 {

	public static void main(String[] args) throws Exception{
		Data d = new Data (1,1);
		//d = new Data(2,2);
		d.setValues(2,2);
	}

}
