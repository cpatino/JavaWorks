package co.com.carp.petcity.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the petfood database table.
 * 
 */
@Entity
public class Petfood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identification;

	private String name;

	//bi-directional many-to-one association to Foodbrand
    @ManyToOne
	@JoinColumn(name="idFoodBrand")
	private Foodbrand foodbrand;

	//bi-directional many-to-one association to Pettype
    @ManyToOne
	@JoinColumn(name="idPetType")
	private Pettype pettype;

	//bi-directional many-to-one association to Petvisitinfo
	@OneToMany(mappedBy="petfood", fetch=FetchType.EAGER)
	private List<Petvisitinfo> petvisitinfos;

    public Petfood() {
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

	public Foodbrand getFoodbrand() {
		return this.foodbrand;
	}

	public void setFoodbrand(Foodbrand foodbrand) {
		this.foodbrand = foodbrand;
	}
	
	public Pettype getPettype() {
		return this.pettype;
	}

	public void setPettype(Pettype pettype) {
		this.pettype = pettype;
	}
	
	public List<Petvisitinfo> getPetvisitinfos() {
		return this.petvisitinfos;
	}

	public void setPetvisitinfos(List<Petvisitinfo> petvisitinfos) {
		this.petvisitinfos = petvisitinfos;
	}
	
}