package fr.unilim.info;

public class Animal {
	private String espece;
	private boolean isCarnivore;
	private float poids;

	public Animal(String espece, boolean isCarnivore, float poids) {
		this.espece = espece;
		this.isCarnivore = isCarnivore;
		this.poids = poids;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((espece == null) ? 0 : espece.hashCode());
		result = prime * result + (isCarnivore ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(poids);
		return result;
	}

	@Override
	public String toString() {
		return "espece=[" + espece + "], isCarnivore=[" + isCarnivore
				+ "], poids=[" + poids + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (espece == null) {
			if (other.espece != null)
				return false;
		} else if (!espece.equals(other.espece))
			return false;
		if (isCarnivore != other.isCarnivore)
			return false;
		if (Float.floatToIntBits(poids) != Float.floatToIntBits(other.poids))
			return false;
		return true;
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public boolean isCarnivore() {
		return isCarnivore;
	}

	public void setCarnivore(boolean isCarnivore) {
		this.isCarnivore = isCarnivore;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

}
