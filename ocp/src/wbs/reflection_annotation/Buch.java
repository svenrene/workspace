package wbs.reflection_annotation;

import java.io.Serializable;

public class Buch implements Serializable, Comparable<Buch>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	@PrimaryKey(index = 1)
	private String isbn;
	
		
	@Column
	private String autor;
	
	@Column
	private String titel;
	
	@Column
	private double preis;
	
	public Buch() {
		
	}
	
	public Buch(String isbn, String autor, String titel, double preis) {
		this.isbn = isbn;
		this.autor = autor;
		this.titel = titel;
		this.preis = preis;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	@Override
	public String toString() {
		return "Buch [isbn=" + isbn + ", autor=" + autor + ", titel=" + titel
				+ ", preis=" + preis + "]";
	}

	@Override
	public int compareTo(Buch buch) {
		return this.isbn.compareTo(buch.isbn);
	}

}
