package co.com.carp.petcity.entity;

import java.awt.Image;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class is attempt to manage pets. 
 * 
 * @author Carlos Rodriguez
 * */
public class Pet {
	
	/**
	 * It indicates that pet is a male.
	 */
	public static final String PET_SEX_MALE = "Macho";
	
	/**
	 * It indicates that pet is a female.
	 */
	public static final String PET_SEX_FEMALE = "Hembra";
	
	/**
	 * Indicates that reproduction is entire
	 */
	public static final String REPRODUCTION_ENTIRE = "Entero"; 
	
	/**
	 * Indicates that reproduction is sterilized
	 */
	public static final String REPRODUCTION_STERILIZED = "Esterilizado";
	
	/**
	 * Indicates that reproduction is between 1 or 2 births
	 */
	public static final String REPRODUCTION_ONE_TWO = "1 a 2 partos";
	
	/**
	 * Indicates that reproduction is between 3 or 4 births
	 */
	public static final String REPRODUCTION_THREE_FOUR = "3 a 4 partos";
	
	/**
	 * Indicates that reproduction is between 5 or more births
	 */
	public static final String REPRODUCTION_FIVE_MORE = "5 o más partos";
	
	/**
	 * Pet's identification
	 */
	private int identification;
	
	/**
	 * Pet's name
	 * */
	private String name;
	
	/**
	 * Pet's breed
	 */
	private PetBreed breed;
	
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
	private Set<PetDrenching> drenchingSet;
	
	/**
	 * Pet's reproduction
	 */
	private String reproduction;
	
	/**
	 * Pet's photo
	 */
	private Image photo;
	
	/**
	 * Owner document identification
	 */
	private int idOwner;
	
	/**
	 * Vaccines applied to pet
	 */
	private Set<PetVaccine> vaccineSet;
	
	/**
	 * It contains all pet's clinic history, it includes all medical consultations.
	 */
	private Set<ClinicHistory> clinicHistorySet;
	
	/**
	 * Notification message set
	 */
	private TreeSet<Notification> notificationSet;

	public Pet(int identification, String name, String color, String sex,
			Date bornDate, String bornPlace, String reproductionState,
			Image photo, PetBreed petBreed, int idOwner) {
		super();
		this.identification = identification;
		this.name = name;
		this.color = color;
		this.sex = sex;
		this.bornDate = bornDate;
		this.bornPlace = bornPlace;
		this.reproduction = reproductionState;
		this.photo = photo;
		this.breed = petBreed;
		this.idOwner = idOwner;
	}

	public Pet() {
		super();
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
	 * @return the petBreed
	 */
	public PetBreed getBreed() {
		return breed;
	}

	/**
	 * @param petBreed the petBreed to set
	 */
	public void setBreed(PetBreed petBreed) {
		this.breed = petBreed;
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
	public Set<PetDrenching> getDrenching() {
		return drenchingSet;
	}

	/**
	 * @param drenching the drenching to set
	 */
	public void setDrenching(Set<PetDrenching> drenchingSet) {
		this.drenchingSet = drenchingSet;
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
	public Set<PetVaccine> getVaccineSet() {
		return vaccineSet;
	}

	/**
	 * @param vaccineSet the vaccineSet to set
	 */
	public void setVaccineSet(Set<PetVaccine> vaccineSet) {
		this.vaccineSet = vaccineSet;
	}

	/**
	 * @return the clinicHistory
	 */
	public Set<ClinicHistory> getClinicHistorySet() {
		return clinicHistorySet;
	}

	/**
	 * @param clinicHistory the clinicHistory to set
	 */
	public void setClinicHistorySet (Set<ClinicHistory> clinicHistorySet) {
		this.clinicHistorySet = clinicHistorySet;
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

	/**
	 * @return the idOwner
	 */
	public int getIdOwner() {
		return idOwner;
	}

	/**
	 * @param idOwner the idOwner to set
	 */
	public void setIdOwner(int idOwner) {
		this.idOwner = idOwner;
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
				+ ((clinicHistorySet == null) ? 0 : clinicHistorySet.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((drenchingSet == null) ? 0 : drenchingSet.hashCode());
		result = prime * result + identification;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((notificationSet == null) ? 0 : notificationSet.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result
				+ ((reproduction == null) ? 0 : reproduction.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
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
		if (clinicHistorySet == null) {
			if (other.clinicHistorySet != null) {
				return false;
			}
		} else if (!clinicHistorySet.equals(other.clinicHistorySet)) {
			return false;
		}
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (drenchingSet == null) {
			if (other.drenchingSet != null) {
				return false;
			}
		} else if (!drenchingSet.equals(other.drenchingSet)) {
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
		if (breed == null) {
			if (other.breed != null) {
				return false;
			}
		} else if (!breed.equals(other.breed)) {
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
				+ ", breed=" + breed + ", color=" + color + ", sex=" + sex
				+ ", bornDate=" + bornDate + ", bornPlace=" + bornPlace
				+ ", drenching=" + drenchingSet + ", reproduction=" + reproduction
				+ ", photo=" + photo + ", vaccineSet=" + vaccineSet
				+ ", notificationSet=" + this.notificationSet.toString()
				+ ", clinicHistory=" + clinicHistorySet + "]";
	}
}