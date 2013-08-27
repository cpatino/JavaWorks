package co.com.carp.petcity.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pettype database table.
 * 
 */
@Entity
public class Pettype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identification;

	@Column(name="class")
	private String class_;

	private String name;

	//bi-directional many-to-one association to Pet
	@OneToMany(mappedBy="pettype", fetch=FetchType.EAGER)
	private List<Pet> pets;

	//bi-directional many-to-one association to Petbreed
	@OneToMany(mappedBy="pettype", fetch=FetchType.EAGER)
	private List<Petbreed> petbreeds;

	//bi-directional many-to-one association to Petfood
	@OneToMany(mappedBy="pettype", fetch=FetchType.EAGER)
	private List<Petfood> petfoods;

    public Pettype() {
    }

	public int getIdentification() {
		return this.identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
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
	
	public List<Petbreed> getPetbreeds() {
		return this.petbreeds;
	}

	public void setPetbreeds(List<Petbreed> petbreeds) {
		this.petbreeds = petbreeds;
	}
	
	public List<Petfood> getPetfoods() {
		return this.petfoods;
	}

	public void setPetfoods(List<Petfood> petfoods) {
		this.petfoods = petfoods;
	}
	
}