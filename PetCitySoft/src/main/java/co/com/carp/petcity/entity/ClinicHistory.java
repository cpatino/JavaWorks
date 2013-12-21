package co.com.carp.petcity.entity;

import java.util.Date;
import java.util.TreeSet;

/**
 * This class is attempt to control pet's clinic history
 * 
 * @author Carlos Rodriguez
 *
 */
public class ClinicHistory {
	
	/**
	 * Database identification
	 */
	private int identification;
	
	/**
	 * Date from first medical consultation.
	 */
	private Date openDate;
	
	/**
	 * User creator for clinic history
	 */
	private User userIdentification;
	
	/**
	 * Pet's medical consultation set
	 */
	private TreeSet<MedicalConsultation> consultationSet;
	
	
	public ClinicHistory(int identification, Date openDate,User userIdentification,TreeSet<MedicalConsultation> consultationSet) {
		this.identification= identification;
		this.openDate = openDate;
		this.userIdentification = userIdentification;
		this.consultationSet = consultationSet;
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
	 * @return the openDate
	 */
	public Date getOpenDate() {
		return openDate;
	}

	/**
	 * @param openDate the openDate to set
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	/**
	 * @return the userIdentification
	 */
	public User getUserIdentification() {
		return userIdentification;
	}

	/**
	 * @param userIdentification the userIdentification to set
	 */
	public void setUserIdentification(User userIdentification) {
		this.userIdentification = userIdentification;
	}

	/**
	 * @return the consultationSet
	 */
	public TreeSet<MedicalConsultation> getConsultationSet() {
		return consultationSet;
	}

	/**
	 * @param consultationSet the consultationSet to set
	 */
	public void setConsultationSet(TreeSet<MedicalConsultation> consultationSet) {
		this.consultationSet = consultationSet;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((consultationSet == null) ? 0 : consultationSet.hashCode());
		result = prime * result + identification;
		result = prime * result
				+ ((openDate == null) ? 0 : openDate.hashCode());
		result = prime * result + userIdentification.getIdentification();
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
		if (!(obj instanceof ClinicHistory)) {
			return false;
		}
		ClinicHistory other = (ClinicHistory) obj;
		if (consultationSet == null) {
			if (other.consultationSet != null) {
				return false;
			}
		} else if (!consultationSet.equals(other.consultationSet)) {
			return false;
		}
		if (identification != other.identification) {
			return false;
		}
		if (openDate == null) {
			if (other.openDate != null) {
				return false;
			}
		} else if (!openDate.equals(other.openDate)) {
			return false;
		}
		if (userIdentification != other.userIdentification) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PetMedicalHistory={identification:" + this.identification + 
				";openDate:" + this.openDate.toString() + 
				";userIdentification:" + this.userIdentification +
				";consultationSet:" + this.consultationSet.toString() +
				"}";
	}

}