package wbs.intro;

import wbs.util.ValidationUtil;

public class Ansprechpartner {

	private String name;
	private String durchwahl;
	private Position position;
	private String email;

	public Ansprechpartner(String name, String durchwahl, Position position) {
		super();
		this.name = name;
		this.durchwahl = durchwahl;
		this.position = position;
	}

	public Ansprechpartner(String name, String durchwahl, Position position,
			String email) {

		this(name, durchwahl, position);
		setEmail(email);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDurchwahl() {
		return durchwahl;
	}

	public void setDurchwahl(String durchwahl) {
		this.durchwahl = durchwahl;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Ansprechpartner [name=" + name + ", durchwahl=" + durchwahl
				+ ", position=" + position + ", email=" + email + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		ValidationUtil.validateEmail(email);
		this.email = email;
	}

}
