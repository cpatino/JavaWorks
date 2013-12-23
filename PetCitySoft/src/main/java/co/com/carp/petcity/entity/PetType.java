package co.com.carp.petcity.entity;

import java.util.Set;

/**
 * This class is attempt to manage pet type 
 * 
 * @author Carlos Rodriguez
 * */
public class PetType implements Comparable<PetType> {
	
	/** 
	 * Pet type identification
	 * */
	private int identification;
	
	/** 
	 * Pet type name
	 * */
	private String name;
	
	/**
	 * Pet type class
	 */
	private String typeClass;
	
	/**
	 * A set of breed enabled to pet type, It will be only used in combo box to display values enabled 
	 * when a pet type is selected.
	 * */
	private Set<PetBreed> breedSet;
	
	public PetType() {
		super();
	}
	
	public PetType(int identification, String name, String typeClass) {
		this.identification = identification;
		this.name = name;
	}

	/**
	 * @return the identification
	 */
	public int getIdentification() {
		return identification;
	}

	/**
	 * @param identification the identification to set
	 */
	public void setIdentification(int identification) {
		this.identification = identification;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the typeClass
	 */
	public String getTypeClass() {
		return typeClass;
	}

	/**
	 * @param typeClass the typeClass to set
	 */
	public void setTypeClass(String typeClass) {
		this.typeClass = typeClass;
	}

	/**
	 * @return the breedSet
	 */
	public Set<PetBreed> getBreedSet() {
		return breedSet;
	}

	/**
	 * @param breedSet the breedSet to set
	 */
	public void setBreedSet(Set<PetBreed> breedSet) {
		this.breedSet = breedSet;
	}
	
	@Override
	public boolean equals(Object arg) {
		if (arg == null || !(arg instanceof PetType)) {
			return false;
		}
		if  (!this.name.equals(((PetType)arg).name)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PetType [identification=" + identification + ", name=" + name
				+ ", class=" + typeClass + ", breedMap=" + breedSet + "]";
	}

	@Override
	public int compareTo(PetType otherPetType) {
		return this.name.compareToIgnoreCase(otherPetType.name);
	}

}
