package co.com.carp.petcity.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the foodbrand database table.
 * 
 */
@Entity
public class Foodbrand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identification;

	private String name;

	private String other;

	//bi-directional many-to-one association to Petfood
	@OneToMany(mappedBy="foodbrand", fetch=FetchType.EAGER)
	private List<Petfood> petfoods;

    public Foodbrand() {
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

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public List<Petfood> getPetfoods() {
		return this.petfoods;
	}

	public void setPetfoods(List<Petfood> petfoods) {
		this.petfoods = petfoods;
	}
	
}