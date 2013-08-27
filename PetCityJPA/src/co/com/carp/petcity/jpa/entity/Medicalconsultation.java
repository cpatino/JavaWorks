package co.com.carp.petcity.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the medicalconsultation database table.
 * 
 */
@Entity
public class Medicalconsultation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identification;

	private String anamnesis;

    @Temporal( TemporalType.TIMESTAMP)
	private Date consultationDate;

	private String control;

	private String diagnosis;

	private String findings;

	private String illness;

	private String motive;

	private String treatment;

	//bi-directional many-to-one association to Clinichistory
    @ManyToOne
	@JoinColumn(name="idClinicHistory")
	private Clinichistory clinichistory;

	//bi-directional many-to-one association to Petexam
	@OneToMany(mappedBy="medicalconsultation", fetch=FetchType.EAGER)
	private List<Petexam> petexams;

	//bi-directional many-to-one association to Petvisitinfo
	@OneToMany(mappedBy="medicalconsultation", fetch=FetchType.EAGER)
	private List<Petvisitinfo> petvisitinfos;

    public Medicalconsultation() {
    }

	public int getIdentification() {
		return this.identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public String getAnamnesis() {
		return this.anamnesis;
	}

	public void setAnamnesis(String anamnesis) {
		this.anamnesis = anamnesis;
	}

	public Date getConsultationDate() {
		return this.consultationDate;
	}

	public void setConsultationDate(Date consultationDate) {
		this.consultationDate = consultationDate;
	}

	public String getControl() {
		return this.control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getFindings() {
		return this.findings;
	}

	public void setFindings(String findings) {
		this.findings = findings;
	}

	public String getIllness() {
		return this.illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public String getMotive() {
		return this.motive;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}

	public String getTreatment() {
		return this.treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public Clinichistory getClinichistory() {
		return this.clinichistory;
	}

	public void setClinichistory(Clinichistory clinichistory) {
		this.clinichistory = clinichistory;
	}
	
	public List<Petexam> getPetexams() {
		return this.petexams;
	}

	public void setPetexams(List<Petexam> petexams) {
		this.petexams = petexams;
	}
	
	public List<Petvisitinfo> getPetvisitinfos() {
		return this.petvisitinfos;
	}

	public void setPetvisitinfos(List<Petvisitinfo> petvisitinfos) {
		this.petvisitinfos = petvisitinfos;
	}
	
}