package co.com.carp.petcity.entity;

import java.awt.Image;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * This class is attempt to manage pets. 
 * 
 * @author Carlos Rodriguez
 * */
public class Pet {
	
	/**
	 * Pet's identification
	 */
	private int identification;
	
	/**
	 * Pet's name
	 * */
	private String name;
	
	/**
	 * Pet's type
	 */
	private PetType type;
	
	/**
	 * Pet's color
	 */
	private String color;	
	
	/**
	 * Pet's sex
	 */
	private String sex;
	
	/**
	 * Pet's born date
	 */
	private Date bornDate;
	
	/**
	 * Pet's born place
	 */
	private String bornPlace;
	
	/**
	 * Pet's drenching set
	 */
	private HashSet<PetDrenching> drenching;
	
	/**
	 * Pet's reproduction
	 */
	private String reproduction;
	
	/**
	 * Pet's photo
	 */
	private Image photo;
	
	/**
	 * Vaccines applied to pet
	 */
	private TreeSet<PetVaccine> vaccineSet;
	
	/**
	 * It contains all pet's clinic history, it includes all medical consultations.
	 */
	private ClinicHistory clinicHistory;
	
	/**
	 * Notification message set
	 */
	private TreeSet<Notification> notificationSet;

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
	 * @return the type
	 */
	public PetType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(PetType type) {
		this.type = type;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the bornDate
	 */
	public Date getBornDate() {
		return bornDate;
	}

	/**
	 * @param bornDate the bornDate to set
	 */
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	/**
	 * @return the bornPlace
	 */
	public String getBornPlace() {
		return bornPlace;
	}

	/**
	 * @param bornPlace the bornPlace to set
	 */
	public void setBornPlace(String bornPlace) {
		this.bornPlace = bornPlace;
	}

	/**
	 * @return the drenching
	 */
	public HashSet<PetDrenching> getDrenching() {
		return drenching;
	}

	/**
	 * @param drenching the drenching to set
	 */
	public void setDrenching(HashSet<PetDrenching> drenching) {
		this.drenching = drenching;
	}

	/**
	 * @return the reproduction
	 */
	public String getReproduction() {
		return reproduction;
	}

	/**
	 * @param reproduction the reproduction to set
	 */
	public void setReproduction(String reproduction) {
		this.reproduction = reproduction;
	}

	/**
	 * @return the photo
	 */
	public Image getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(Image photo) {
		this.photo = photo;
	}

	/**
	 * @return the vaccineSet
	 */
	public TreeSet<PetVaccine> getVaccineSet() {
		return vaccineSet;
	}

	/**
	 * @param vaccineSet the vaccineSet to set
	 */
	public void setVaccineSet(TreeSet<PetVaccine> vaccineSet) {
		this.vaccineSet = vaccineSet;
	}

	/**
	 * @return the clinicHistory
	 */
	public ClinicHistory getClinicHistory() {
		return clinicHistory;
	}

	/**
	 * @param clinicHistory the clinicHistory to set
	 */
	public void setClinicHistory(ClinicHistory clinicHistory) {
		this.clinicHistory = clinicHistory;
	}
	
	/**
	 * @return the notificationSet
	 */
	public TreeSet<Notification> getNotificationSet() {
		return notificationSet;
	}

	/**
	 * @param notificationSet the notificationSet to set
	 */
	public void setNotificationSet(TreeSet<Notification> notificationSet) {
		this.notificationSet = notificationSet;
	}	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bornDate == null) ? 0 : bornDate.hashCode());
		result = prime * result
				+ ((bornPlace == null) ? 0 : bornPlace.hashCode());
		result = prime * result
				+ ((clinicHistory == null) ? 0 : clinicHistory.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((drenching == null) ? 0 : drenching.hashCode());
		result = prime * result + identification;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((notificationSet == null) ? 0 : notificationSet.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result
				+ ((reproduction == null) ? 0 : reproduction.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((vaccineSet == null) ? 0 : vaccineSet.hashCode());
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
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Pet)) {
			return false;
		}
		Pet other = (Pet) obj;
		if (bornDate == null) {
			if (other.bornDate != null) {
				return false;
			}
		} else if (!bornDate.equals(other.bornDate)) {
			return false;
		}
		if (bornPlace == null) {
			if (other.bornPlace != null) {
				return false;
			}
		} else if (!bornPlace.equals(other.bornPlace)) {
			return false;
		}
		if (clinicHistory == null) {
			if (other.clinicHistory != null) {
				return false;
			}
		} else if (!clinicHistory.equals(other.clinicHistory)) {
			return false;
		}
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (drenching == null) {
			if (other.drenching != null) {
				return false;
			}
		} else if (!drenching.equals(other.drenching)) {
			return false;
		}
		if (identification != other.identification) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (notificationSet == null) {
			if (other.notificationSet != null) {
				return false;
			}
		} else if (!notificationSet.equals(other.notificationSet)) {
			return false;
		}
		if (photo == null) {
			if (other.photo != null) {
				return false;
			}
		} else if (!photo.equals(other.photo)) {
			return false;
		}
		if (reproduction == null) {
			if (other.reproduction != null) {
				return false;
			}
		} else if (!reproduction.equals(other.reproduction)) {
			return false;
		}
		if (sex == null) {
			if (other.sex != null) {
				return false;
			}
		} else if (!sex.equals(other.sex)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (vaccineSet == null) {
			if (other.vaccineSet != null) {
				return false;
			}
		} else if (!vaccineSet.equals(other.vaccineSet)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pet [identification=" + identification + ", name=" + name
				+ ", type=" + type + ", color=" + color + ", sex=" + sex
				+ ", bornDate=" + bornDate + ", bornPlace=" + bornPlace
				+ ", drenching=" + drenching + ", reproduction=" + reproduction
				+ ", photo=" + photo + ", vaccineSet=" + vaccineSet
				+ ", notificationSet=" + this.notificationSet.toString()
				+ ", clinicHistory=" + clinicHistory + "]";
	}
}