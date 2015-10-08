package wbs.string_processing;

public class BeispielDemo {

	public static void main(String[] args) {
	
	System.out.printf("Der Preis ist: %.2f€%n", 5.99);
	System.out.printf("%s sagt: %d ist %2$dmal zuviel. %n",
	"Konfuzius", 100);
	int i1 = -123;
	int i2 = 12345;
	System.out.printf(">%1$(7d< %n", i1);
	System.out.printf(">%0,7d< %n", i2);
	System.out.printf(">%+-7d< %n", i2);
	System.out.printf(">%2$b + %1$5d< %n", i1, false);
	System.out.printf(">%s + %S< %n", i1+1, "test");
	
	}
	
}
