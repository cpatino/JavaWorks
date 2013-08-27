package co.com.carp.petcity.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the petvaccine database table.
 * 
 */
@Entity
public class Petvaccine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identification;

    @Temporal( TemporalType.TIMESTAMP)
	private Date applicationDate;

	private String name;

	//bi-directional many-to-one association to Pet
    @ManyToOne
	@JoinColumn(name="idPet")
	private Pet pet;

    public Petvaccine() {
    }

	public int getIdentification() {
		return this.identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public Date getApplicationDate() {
		return this.applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pet getPet() {
		return this.pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
}