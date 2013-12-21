package co.com.carp.petcity.entity;

/**
 * This class is attempt to stored information that is often obtained when 
 * a pet comes to get a clinic consulting.
 * 
 * @author Carlos Rodriguez
 *
 */
public class PetVisitInfo {
	
	/**
	 * Database identification
	 */
	private int identification; 
	
	/**
	 * Pet's weight
	 */
	private float weight;
	
	/**
	 * Pet's food
	 */
	private PetFood food;
	
	/**
	 * Pet's corporal condition
	 */
	private String corporalCondition;
	
	public PetVisitInfo(int identification,float weight,PetFood food,String corporalCondition) {
		this.identification = identification;
		this.weight = weight;
		this.food = food;
		this.corporalCondition = corporalCondition;
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
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * @return the food
	 */
	public PetFood getFood() {
		return food;
	}

	/**
	 * @param food the food to set
	 */
	public void setFood(PetFood food) {
		this.food = food;
	}
	
	/**
	 * @return the corporalCondition
	 */
	public String getCorporalCondition() {
		return corporalCondition;
	}

	/**
	 * @param corporalCondition the corporalCondition to set
	 */
	public void setCorporalCondition(String corporalCondition) {
		this.corporalCondition = corporalCondition;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((corporalCondition == null) ? 0 : corporalCondition
						.hashCode());
		result = prime * result + ((food == null) ? 0 : food.hashCode());
		result = prime * result + identification;
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
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
		PetVisitInfo other = (PetVisitInfo) obj;
		if (corporalCondition == null) {
			if (other.corporalCondition != null)
				return false;
		} else if (!corporalCondition.equals(other.corporalCondition))
			return false;
		if (food == null) {
			if (other.food != null)
				return false;
		} else if (!food.equals(other.food))
			return false;
		if (identification != other.identification)
			return false;
		if (Double.doubleToLongBits(weight) != Double
				.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PetVisitInfo [identification=" + identification + ", weight="
				+ weight + ", food=" + food + ", corporalCondition="
				+ corporalCondition + "]";
	}
}