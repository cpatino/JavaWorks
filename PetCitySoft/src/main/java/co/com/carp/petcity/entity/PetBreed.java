package co.com.carp.petcity.entity;

/**
 * This class is attempt to manage pet's breeds. 
 * 
 * @author Carlos Rodriguez
 * */
public class PetBreed implements Comparable<PetBreed> {
	
	/** 
	 * Breed identification
	 * */
	private int identification;
	
	/** 
	 * Breed name
	 * */
	private String name;
	
	/**
	 * Pet type from pet breed.
	 */
	private PetType petType;
	
	public PetBreed() {
		super();
	}
	
	public PetBreed(int identification, String name, PetType petType) {
		this.identification= identification;
		this.name = name;
		this.petType = petType;
	}
	
	/**
	 * @return breed identification	 * 
	 * */
	public int getIdentification() {
		return identification;
	}

	/**
	 * @param identification the identification to set
	 * */
	public void setIdentification(int identification) {
		this.identification = identification;
	}

	/**
	 * @return the name
	 * */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 * */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the petType
	 */
	public PetType getPetType() {
		return petType;
	}

	/**
	 * @param petType the petType to set
	 */
	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	@Override
	public boolean equals(Object arg) {
		if (arg == null || !(arg instanceof PetBreed)) {
			return false;
		}
		if  (!this.name.equals(((PetBreed)arg).name)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hashCode = 85;
		hashCode = hashCode * name.hashCode();
		return hashCode;
	}

	@Override
	public String toString() {
		return "Breed={identification:" + this.identification + ";name:" + this.name + "}";
	}

	@Override
	public int compareTo(PetBreed otherBreed) {
		return this.name.compareToIgnoreCase(otherBreed.name);
	}

}
