package fr.unilim.info;

public class Animal {
	private String espece;
	private boolean carnivore;
	private float poids;

	public Animal(String espece, boolean isCarnivore, float poids) {
		this.espece = espece;
		this.carnivore = isCarnivore;
		this.poids = poids;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((espece == null) ? 0 : espece.hashCode());
		result = prime * result + (carnivore ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(poids);
		return result;
	}

	@Override
	public String toString() {
		return "espece=[" + espece + "], isCarnivore=[" + carnivore
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
		if (carnivore != other.carnivore)
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
		return carnivore;
	}

	public void setCarnivore(boolean isCarnivore) {
		this.carnivore = isCarnivore;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public boolean necessiteSoin(SoinEnum typeSoin) {
		if (typeSoin.equals(SoinEnum.DENTS) && this.isCarnivore()) {
			return true;
		}
		if (typeSoin.equals(SoinEnum.PIEDS) && this.getPoids() > 200) {
			return true;
		}
		return false;
	}

	public float calculerViandeHebdo() {
		if (this.isCarnivore()) {
			return this.getPoids() * 0.25f;
		}
		return 0.0f;
	}

}
