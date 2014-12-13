package fr.unilim.info;

/**
 * Classe représentant un animal défini par un nom d'espèce,
 * son poids et s'il est carnivore ou non
 *
 */
public class Animal {
	private String espece;
	private boolean carnivore;
	private float poids;

	/**
	 * Constructeur d'animal.
	 * 
	 * @param espece
	 *            : espèce de l'animal.
	 * @param isCarnivore
	 *            : détermine l'alimentation de l'animal.
	 * @param poids
	 *            : poids de l'animal.
	 */
	public Animal(String espece, boolean isCarnivore, float poids) {
		this.espece = espece;
		this.carnivore = isCarnivore;
		this.poids = poids;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((espece == null) ? 0 : espece.hashCode());
		result = prime * result + (carnivore ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(poids);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "espece=[" + espece + "], isCarnivore=[" + carnivore
				+ "], poids=[" + poids + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	/**
	 * Getter d'espèce.
	 * 
	 * @return l'espèce de l'animal.
	 */
	public String getEspece() {
		return espece;
	}

	/**
	 * Setter d'espèce.
	 * 
	 * @param espece
	 *            : espèce de l'animal.
	 */
	public void setEspece(String espece) {
		this.espece = espece;
	}

	/**
	 * Getter : l'alimentation de l'animal.
	 * 
	 * @return un booléen : vrai si l'animal est carnivore faux sinon.
	 */
	public boolean isCarnivore() {
		return carnivore;
	}

	/**
	 * Setter : alimentation de l'animal.
	 * 
	 * @param isCarnivore
	 *            : vrai si l'animal est carnivore faux sinon.
	 */
	public void setCarnivore(boolean isCarnivore) {
		this.carnivore = isCarnivore;
	}

	/**
	 * Getter poids : retourne le poids de l'animal.
	 * 
	 * @return float : poids de l'animal.
	 */
	public float getPoids() {
		return poids;
	}

	/**
	 * Setter poids : affecte un poids à l'animal.
	 * 
	 * @param poids
	 *            : poids de l'animal.
	 */
	public void setPoids(float poids) {
		this.poids = poids;
	}

	/**
	 * Renvoie un booléen déterminant si il faut soigner l'animal.
	 * 
	 * @param typeSoin
	 *            : DENTS ou PIEDS.
	 * @return : booléen : vrai si il faut le soigner, faux sinon.
	 */
	public boolean necessiteSoin(SoinEnum typeSoin) {
		if (typeSoin.equals(SoinEnum.DENTS) && this.isCarnivore()) {
			return true;
		}
		if (typeSoin.equals(SoinEnum.PIEDS) && this.getPoids() > 200) {
			return true;
		}
		return false;
	}

	/**
	 * Renvoie la quantité de viande à fournir à l'animal pour une semaine.
	 * 
	 * @return float : quantité de viande.
	 */
	public float calculerViandeHebdo() {
		if (this.isCarnivore()) {
			return this.getPoids() * 0.25f;
		}
		return 0.0f;
	}

}
