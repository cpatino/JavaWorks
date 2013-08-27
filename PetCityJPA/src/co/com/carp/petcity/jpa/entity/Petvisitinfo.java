package co.com.carp.petcity.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the petvisitinfo database table.
 * 
 */
@Entity
public class Petvisitinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identification;

	private String corporalCondition;

	private float weight;

	//bi-directional many-to-one association to Medicalconsultation
    @ManyToOne
	@JoinColumn(name="idMedicalConsultation")
	private Medicalconsultation medicalconsultation;

	//bi-directional many-to-one association to Petfood
    @ManyToOne
	@JoinColumn(name="idPetFood")
	private Petfood petfood;

    public Petvisitinfo() {
    }

	public int getIdentification() {
		return this.identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public String getCorporalCondition() {
		return this.corporalCondition;
	}

	public void setCorporalCondition(String corporalCondition) {
		this.corporalCondition = corporalCondition;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Medicalconsultation getMedicalconsultation() {
		return this.medicalconsultation;
	}

	public void setMedicalconsultation(Medicalconsultation medicalconsultation) {
		this.medicalconsultation = medicalconsultation;
	}
	
	public Petfood getPetfood() {
		return this.petfood;
	}

	public void setPetfood(Petfood petfood) {
		this.petfood = petfood;
	}
	
}