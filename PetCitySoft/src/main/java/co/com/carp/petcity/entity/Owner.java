package co.com.carp.petcity.entity;

import java.util.Set;

/**
 * This class is attempt to be an implementation of person, this class represent 
 * pet's owner. 
 * 
 * @author Carlos Rodriguez
 * */
public class Owner extends Person implements Comparable<Owner> {
	

	

	/**
	 * Owner home address
	 */
	private String address;
	
	/**
	 * Owner cell-phone
	 */
	private String cellphone;
	
	/**
	 * Owner phone
	 */
	private String phone;
	
	/**
	 * Pet set from owner
	 */
	private Set<Pet> petSet;
	
	
	public Owner(int identification, int documentId, String name, String email) {
		super(identification, documentId, name, email);
	}
	
	public Owner(int identification, int documentId, String name, String email, String address, String cellphone, String phone) {
		super(identification, documentId, name, email);
		this.address = address;
		this.cellphone = cellphone;
		this.phone = phone;
	}

	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the cellphone
	 */
	public String getCellphone() {
		return cellphone;
	}

	/**
	 * @param cellphone the cellphone to set
	 */
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the petSet
	 */
	public Set<Pet> getPetSet() {
		return petSet;
	}

	/**
	 * @param petSet the petSet to set
	 */
	public void setPetSet(Set<Pet> petSet) {
		this.petSet = petSet;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((cellphone == null) ? 0 : cellphone.hashCode());		
		result = prime * result
				+ ((phone == null) ? 0 : cellphone.hashCode());
		
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Owner)) {
			return false;
		}
		Owner other = (Owner) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (cellphone == null) {
			if (other.cellphone != null) {
				return false;
			}
		} else if (!cellphone.equals(other.cellphone)) {
			return false;
		}
		if (phone != other.phone) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ";Owner={" + this.address + ";" +
				"cellphone:" + this.cellphone + ";" +
				"phone:" + this.phone + ";" +
				"petSet:" + this.petSet + ";" +				 
				";}";
	}

	@Override
	public int compareTo(Owner otherOwner) {
		return this.getName().compareToIgnoreCase(otherOwner.getName());
	}

}
