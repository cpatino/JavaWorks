package co.com.carp.petcity.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clinichistory database table.
 * 
 */
@Entity
public class Clinichistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identification;

    @Temporal( TemporalType.TIMESTAMP)
	private Date openDate;

	//bi-directional many-to-one association to Pet
    @ManyToOne
	@JoinColumn(name="idPet")
	private Pet pet;

	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="creatorUser")
	private User user;

	//bi-directional many-to-one association to Medicalconsultation
	@OneToMany(mappedBy="clinichistory", fetch=FetchType.EAGER)
	private List<Medicalconsultation> medicalconsultations;

    public Clinichistory() {
    }

	public int getIdentification() {
		return this.identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public Date getOpenDate() {
		return this.openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Pet getPet() {
		return this.pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Medicalconsultation> getMedicalconsultations() {
		return this.medicalconsultations;
	}

	public void setMedicalconsultations(List<Medicalconsultation> medicalconsultations) {
		this.medicalconsultations = medicalconsultations;
	}
	
}