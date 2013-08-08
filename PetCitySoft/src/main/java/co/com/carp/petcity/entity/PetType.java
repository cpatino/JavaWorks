package co.com.carp.petcity.entity;

import java.util.Map;

/**
 * This class is attempt to manage pet type 
 * 
 * @author Carlos Rodriguez
 * */
public class PetType {
	
	/** 
	 * Pet type identification
	 * */
	private int identification;
	
	/** 
	 * Pet type name
	 * */
	private String name;
	
	/**
	 * A set of breed enabled to pet type
	 * */
	private Map<Integer, PetBreed> breedMap;
	
	/**
	 * Current breed by pet
	 * */
	private int breedSelected;

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
	 * @return the breedSet
	 */
	public Map<Integer, PetBreed> getBreedMap() {
		return breedMap;
	}

	/**
	 * @param breedSet the breedSet to set
	 */
	public void setBreedMap(Map<Integer, PetBreed> breedMap) {
		this.breedMap = breedMap;
	}

	/**
	 * @return the breedSelected
	 */
	public int getBreedSelected() {
		return breedSelected;
	}

	/**
	 * @param breedSelected the breedSelected to set
	 */
	public void setBreedSelected(int breedSelected) {
		this.breedSelected = breedSelected;
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
	
	@Override
	public String toString() {
		return "PetType={identification:" + this.identification + ";name:" + this.name + 
				";breedSet:" + this.getBreedMap().toString() + ";breedSelected:" + this.breedSelected +
				"}";
	}

}
