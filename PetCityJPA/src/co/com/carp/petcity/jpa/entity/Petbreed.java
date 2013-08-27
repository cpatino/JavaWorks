package co.com.carp.petcity.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the petbreed database table.
 * 
 */
@Entity
public class Petbreed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identification;

	private String name;

	//bi-directional many-to-one association to Pet
	@OneToMany(mappedBy="petbreed", fetch=FetchType.EAGER)
	private List<Pet> pets;

	//bi-directional many-to-one association to Pettype
    @ManyToOne
	@JoinColumn(name="idPetType")
	private Pettype pettype;

    public Petbreed() {
    }

	public int getIdentification() {
		return this.identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pet> getPets() {
		return this.pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
	public Pettype getPettype() {
		return this.pettype;
	}

	public void setPettype(Pettype pettype) {
		this.pettype = pettype;
	}
	
}