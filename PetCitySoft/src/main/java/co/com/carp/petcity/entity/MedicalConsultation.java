package co.com.carp.petcity.entity;

import java.awt.Image;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This class is attempt to manage pets' medical consultation. 
 * 
 * @author Carlos Rodriguez
 * */
public class MedicalConsultation implements Comparable<MedicalConsultation> {
	
	/**
	 * Identification from database
	 */
	private int identification;
	
	/**
	 * Date from pet medical consultation
	 */
	private Date consultationDate;
	
	/**
	 * Data from pet about the current illness
	 */
	private String anamnesis;
	
	/**
	 * Current illness
	 */
	private String illness;
	
	/**
	 * Pet's medical consultation motive
	 */
	private String motive;
	
	/**
	 * Findings from pet's medical consultation.
	 */
	private String findings;
	
	/**
	 * Diagnosis from pet's medical consultation
	 */
	private String diagnosis;
	
	/**
	 * Recommended treatment
	 */
	private String treatment;
	
	/**
	 * Control to be take in care
	 */
	private String control;
	
	/**
	 * Exam associated with pet's medical consultation
	 */
	private Set<PetExam> examSet;
	
	/**
	 * An image set associated with pet's medical consultation, 
	 * the propose of this is take an image set of records about
	 * current state of pet and control an better analysis about
	 * its evolution in a future medical consulting.
	 */
	private HashSet<Image> imageSet;
	
	/**
	 * An additional information that is always consulted when a pet starts 
	 * a consult.
	 */
	private PetVisitInfo visitAdditionalInfo;
	
	
	public MedicalConsultation() {
		// TODO Auto-generated constructor stub
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
	 * @return the consultationDate
	 */
	public Date getConsultationDate() {
		return consultationDate;
	}

	/**
	 * @param consultationDate the consultationDate to set
	 */
	public void setConsultationDate(Date consultationDate) {
		this.consultationDate = consultationDate;
	}

	/**
	 * @return the anamnesis
	 */
	public String getAnamnesis() {
		return anamnesis;
	}

	/**
	 * @param anamnesis the anamnesis to set
	 */
	public void setAnamnesis(String anamnesis) {
		this.anamnesis = anamnesis;
	}

	/**
	 * @return the illness
	 */
	public String getIllness() {
		return illness;
	}

	/**
	 * @param illness the illness to set
	 */
	public void setIllness(String illness) {
		this.illness = illness;
	}

	/**
	 * @return the motive
	 */
	public String getMotive() {
		return motive;
	}

	/**
	 * @param motive the motive to set
	 */
	public void setMotive(String motive) {
		this.motive = motive;
	}

	/**
	 * @return the findings
	 */
	public String getFindings() {
		return findings;
	}

	/**
	 * @param findings the findings to set
	 */
	public void setFindings(String findings) {
		this.findings = findings;
	}

	/**
	 * @return the diagnosis
	 */
	public String getDiagnosis() {
		return diagnosis;
	}

	/**
	 * @param diagnosis the diagnosis to set
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	/**
	 * @return the treatment
	 */
	public String getTreatment() {
		return treatment;
	}

	/**
	 * @param treatment the treatment to set
	 */
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	/**
	 * @return the control
	 */
	public String getControl() {
		return control;
	}

	/**
	 * @param control the control to set
	 */
	public void setControl(String control) {
		this.control = control;
	}

	/**
	 * @return the exam
	 */
	public Set<PetExam> getExamSet() {
		return examSet;
	}

	/**
	 * @param exam the exam to set
	 */
	public void setExamSet(Set<PetExam> examSet) {
		this.examSet = examSet;
	}

	/**
	 * @return the imageSet
	 */
	public HashSet<Image> getImageSet() {
		return imageSet;
	}

	/**
	 * @param imageSet the imageSet to set
	 */
	public void setImageSet(HashSet<Image> imageSet) {
		this.imageSet = imageSet;
	}

	/**
	 * @return the visitAdditionalInfo
	 */
	public PetVisitInfo getVisitAdditionalInfo() {
		return visitAdditionalInfo;
	}

	/**
	 * @param visitAdditionalInfo the visitAdditionalInfo to set
	 */
	public void setVisitAdditionalInfo(PetVisitInfo visitAdditionalInfo) {
		this.visitAdditionalInfo = visitAdditionalInfo;
	}

	@Override
	public boolean equals(Object arg) {
		if (arg == null || !(arg instanceof MedicalConsultation)) {
			return false;
		}
		if  (!this.consultationDate.equals(((MedicalConsultation)arg).consultationDate)
				|| this.identification != ((MedicalConsultation)arg).identification) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hashCode = 85;
		hashCode = hashCode * this.consultationDate.hashCode() + this.identification;
		return hashCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PetMedicalConsultation [identification=" + identification
				+ ", consultationDate=" + consultationDate + ", anamnesis="
				+ anamnesis + ", illness=" + illness + ", motive=" + motive
				+ ", findings=" + findings + ", diagnosis=" + diagnosis
				+ ", treatment=" + treatment + ", control=" + control
				+ ", exam=" + examSet.size() + ", imageSet=" + imageSet
				+ ", visitAdditionalInfo=" + visitAdditionalInfo + "]";
	}

	@Override
	public int compareTo(MedicalConsultation anotherConsultation) {
		return this.consultationDate.compareTo(anotherConsultation.consultationDate);
	}
}