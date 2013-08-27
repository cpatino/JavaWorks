package co.com.carp.petcity.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the petexam database table.
 * 
 */
@Entity
public class Petexam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identification;

    @Temporal( TemporalType.TIMESTAMP)
	private Date examDate;

    @Lob()
	private byte[] examFile;

	private String examObservation;

	private String name;

	//bi-directional many-to-one association to Medicalconsultation
    @ManyToOne
	@JoinColumn(name="idMedicalConsultation")
	private Medicalconsultation medicalconsultation;

    public Petexam() {
    }

	public int getIdentification() {
		return this.identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public Date getExamDate() {
		return this.examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public byte[] getExamFile() {
		return this.examFile;
	}

	public void setExamFile(byte[] examFile) {
		this.examFile = examFile;
	}

	public String getExamObservation() {
		return this.examObservation;
	}

	public void setExamObservation(String examObservation) {
		this.examObservation = examObservation;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Medicalconsultation getMedicalconsultation() {
		return this.medicalconsultation;
	}

	public void setMedicalconsultation(Medicalconsultation medicalconsultation) {
		this.medicalconsultation = medicalconsultation;
	}
	
}