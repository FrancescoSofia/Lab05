package it.polito.tdp.anagrammi.model;

public class Lettera {
	
	private char lettera;
	private int pos;
	
	public Lettera(char lettera, int pos) {
		super();
		this.lettera = lettera;
		this.pos = pos;
	}

	public char getLettera() {
		return lettera;
	}

	public void setLettera(char lettera) {
		this.lettera = lettera;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lettera;
		result = prime * result + pos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lettera other = (Lettera) obj;
		if (lettera != other.lettera)
			return false;
		if (pos != other.pos)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lettera [lettera=" + lettera + "]";
	}

}
