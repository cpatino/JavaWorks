package co.com.carp.petcity.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the petdrenching database table.
 * 
 */
@Entity
public class Petdrenching implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identification;

    @Temporal( TemporalType.TIMESTAMP)
	private Date drenchingDate;

	private String productName;

	//bi-directional many-to-one association to Pet
    @ManyToOne
	@JoinColumn(name="idPet")
	private Pet pet;

    public Petdrenching() {
    }

	public int getIdentification() {
		return this.identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public Date getDrenchingDate() {
		return this.drenchingDate;
	}

	public void setDrenchingDate(Date drenchingDate) {
		this.drenchingDate = drenchingDate;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Pet getPet() {
		return this.pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
}