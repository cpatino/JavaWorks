package co.com.carp.petcity.entity;

import java.util.Map;

/**
 * This class is attempt to manage pet's food. 
 * 
 * @author Carlos Rodriguez
 * */
public class PetFood {
	
	/** 
	 * Food identification
	 * */
	private int identification;
	
	/** 
	 * Food name
	 * */
	private String name;
	
	/**
	 * Set of food brand
	 */
	private Map<Integer, FoodBrand> foodBrandMap; 
	
	/**
	 * Food brand selected
	 */
	private int foodBrandSelected;

	
	public PetFood(int identification,String name,Map<Integer, FoodBrand> foodBrandMap) {
		
		this.identification = identification;
		this.name = name;
		this.foodBrandMap = foodBrandMap;
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
	 * @return the foodBrandMap
	 */
	public Map<Integer, FoodBrand> getFoodBrandMap() {
		return foodBrandMap;
	}

	/**
	 * @param foodBrandMap the foodBrandMap to set
	 */
	public void setFoodBrandMap(Map<Integer, FoodBrand> foodBrandMap) {
		this.foodBrandMap = foodBrandMap;
	}

	/**
	 * @return the foodBrandSelected
	 */
	public int getFoodBrandSelected() {
		return foodBrandSelected;
	}

	/**
	 * @param foodBrandSelected the foodBrandSelected to set
	 */
	public void setFoodBrandSelected(int foodBrandSelected) {
		this.foodBrandSelected = foodBrandSelected;
	}

	@Override
	public boolean equals(Object arg) {
		if (arg == null || !(arg instanceof PetFood)) {
			return false;
		}
		if  (!this.name.equals(((PetFood)arg).name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PetFood={identification:" + this.identification + ";name:" + this.name + 
				";foodBrand:" + this.foodBrandMap.toString() + ";FoodBrandSelected:" + this.foodBrandSelected +
				"}";
	}
}