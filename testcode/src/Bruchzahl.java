import java.math.BigInteger;
import java.math.BigDecimal;

public class Bruchzahl {
  
  private BigInteger zaehler;
  private BigInteger nenner;

  public Bruchzahl(BigInteger zaehler,BigInteger nenner) {
//    if (nenner.equals(BigInteger.valueOf(0)))
//    {
//      throw new ArithmeticException("Nenner darf nicht 0 sein.");
//    }
    
    this.zaehler = zaehler;
    this.nenner = nenner;
//    // Sonderfall: wir behandeln die Zahl 0
//    
//    if (zaehler.equals(BigInteger.valueOf(0)))
//      nenner = BigInteger.valueOf(1);
//    // Normalfall: die Zahl ist nicht null
//    else {
//      // Berechne den groessten gemeinsamen Teiler
//      BigInteger ggt = zaehler.gcd(nenner);
//      // Teile Zaehler und Nenner durch den ggt
//      this.zaehler = zaehler.divide(ggt);
//      this.nenner = nenner.divide(ggt);
//    }
//    // Sorge dafuer, dass das Vorzeichen im Zaehler steckt
//    if (this.nenner.signum() < 0)
//    {
//      this.nenner = nenner.negate();
//      this.zaehler = zaehler.negate();
//    }  
  }
  
  /** Konstruktor, dem Zaehler und Nenner
    * als long-Werte uebergeben werden.
    **/
  public Bruchzahl(long zaehler,long nenner) {
    this(BigInteger.valueOf(zaehler),BigInteger.valueOf(nenner));
  }
  
//  /** Konstruktor, der einen long-Wert als Eingabegroesse nimmt.
//    * @param zahl eine Gleitkommazahl
//    **/
//  public Bruchzahl(long zahl) {
//    this(zahl,1);
//  }

  /** Konstruktor, der eine Gleitkommazahl als Eingabegroesse
    * nimmt.
    * @param zahl eine Gleitkommazahl als BigDecimal
    **/
  public Bruchzahl(BigDecimal zahl) {
    this(zahl.unscaledValue(),
      BigInteger.valueOf(10).pow(zahl.scale()));
  }
  
  /** Konstruktor, der eine Gleitkommazahl als Eingabegroesse
    * nimmt.
    * @param zahl eine Gleitkommazahl in Textrepraesentation,
    *  z.B. "0.123"
    **/
  public Bruchzahl(String zahl) {
    this(new BigDecimal(zahl));
  }  

  /** Konstruktor, der einen double-Wert als Eingabegroesse nimmt.
    * @param zahl eine Gleitkommazahl
    **/
  public Bruchzahl(double zahl) {
    this(new BigDecimal(zahl));
  }
  
  /** Liefert eine String-Darstellung dieser Zahl */
  public String toString() {
    return (nenner.equals(BigInteger.valueOf(1))) ?
      zaehler.toString() :
      (zaehler.toString() + '/' + nenner.toString());
  }
  
  /** Vergleicht zwei Objekte auf Gleichheit
    * @param o das zu vergleichende Objekt
    * @return true genau dann, wenn das andere Objekt
    *  auch eine Bruchzahl vom gleichen Inhalt ist.
    **/
  public boolean equals(Object o) {
    if (o == null) 
      return false;
    if (this == o) 
      return true; 
    if (getClass() != o.getClass()) 
      return false;
    Bruchzahl b = (Bruchzahl) o;
    return zaehler.equals(b.zaehler) && nenner.equals(b.nenner);
  }
  
  /** Liefert einen Hashcode fuer dieses Objekt zurueck.
    * @return der Hashcode, berechnet aus Zaehler und Nenner
    **/
  public int hashCode() {
    return zaehler.hashCode() * nenner.hashCode();
  }
  
  /** Addiert zwei Bruchzahlen
    * @param zahl der zweite Summand
    * @return this + zahl
    **/
  public Bruchzahl add(Bruchzahl zahl) {
    return new Bruchzahl(
      zaehler.multiply(zahl.nenner).add(nenner.multiply(zahl.zaehler)),
      nenner.multiply(zahl.nenner)
    );
  }
  
  /** Negiert eine Bruchzahl 
    * @return -this
    **/
  public Bruchzahl negate() {
    return new Bruchzahl(zaehler.negate(),nenner);
  }
  
  /** Subtrahiert zwei Bruchzahlen
    * @param zahl der Subtrahend
    * @return this - zahl
    **/
  public Bruchzahl subtract(Bruchzahl zahl) {
    return add(zahl.negate());
  }
  
  /** Multipliziert zwei Bruchzahlen 
    * @param zahl der zweite Faktor
    * @return this * zahl
    **/
  public Bruchzahl multiply(Bruchzahl zahl) {
    return new Bruchzahl(
      zaehler.multiply(zahl.zaehler),
      nenner.multiply(zahl.nenner)
    );
  }
  
  /** Dividiert zwei Bruchzahlen 
    * @param zahl der Divisor
    * @return this / zahl
    **/
  public Bruchzahl divide(Bruchzahl zahl) {
    return new Bruchzahl(
      zaehler.multiply(zahl.nenner),
      nenner.multiply(zahl.zaehler)
    );
  }
 
  /** Ein kleiner Test unserer Implementierung */
  public static void main(String[] args) {
   // Gib einige umgewandelte Zahlen aus
//   System.out.println(new Bruchzahl(1,3));
//   System.out.println(new Bruchzahl(2,-6));
//   System.out.println(new Bruchzahl(3));
//   System.out.println(new Bruchzahl(0.1)); // Achtung!
//   System.out.println(new Bruchzahl("0.1"));
//   System.out.println(new Bruchzahl(0));
   // Fuehre einige Rechenoperationen aus
   System.out.println(new Bruchzahl(1,5).add(new Bruchzahl(1,5)));
   System.out.println(new Bruchzahl(1,3).subtract(new Bruchzahl(1,6)));
   System.out.println(new Bruchzahl(2,3).multiply(new Bruchzahl(1,6)));
   System.out.println(new Bruchzahl(1,3).divide(new Bruchzahl(1,6)));
   // Vergleiche zwei Objekte auf Gleichheit
//   System.out.println(new Bruchzahl(1,-3).equals(new Bruchzahl(-2,6)));
  }
  
}