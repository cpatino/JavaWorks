package co.com.carp.petcity.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pet database table.
 * 
 */
@Entity
public class Pet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identification;

    @Temporal( TemporalType.TIMESTAMP)
	private Date bornDate;

	private String bornPlace;

	private String color;

	private String name;

    @Lob()
	private byte[] photo;

	private String reproductionState;

	private String sex;

	//bi-directional many-to-one association to Clinichistory
	@OneToMany(mappedBy="pet", fetch=FetchType.EAGER)
	private List<Clinichistory> clinichistories;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="pet", fetch=FetchType.EAGER)
	private List<Notification> notifications;

	//bi-directional many-to-one association to Petbreed
    @ManyToOne
	@JoinColumn(name="idPetBreed")
	private Petbreed petbreed;

	//bi-directional many-to-one association to Pettype
    @ManyToOne
	@JoinColumn(name="idPetType")
	private Pettype pettype;

	//bi-directional many-to-one association to Petdrenching
	@OneToMany(mappedBy="pet", fetch=FetchType.EAGER)
	private List<Petdrenching> petdrenchings;

	//bi-directional many-to-one association to Petvaccine
	@OneToMany(mappedBy="pet", fetch=FetchType.EAGER)
	private List<Petvaccine> petvaccines;

    public Pet() {
    }

	public int getIdentification() {
		return this.identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public Date getBornDate() {
		return this.bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public String getBornPlace() {
		return this.bornPlace;
	}

	public void setBornPlace(String bornPlace) {
		this.bornPlace = bornPlace;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getReproductionState() {
		return this.reproductionState;
	}

	public void setReproductionState(String reproductionState) {
		this.reproductionState = reproductionState;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Clinichistory> getClinichistories() {
		return this.clinichistories;
	}

	public void setClinichistories(List<Clinichistory> clinichistories) {
		this.clinichistories = clinichistories;
	}
	
	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	
	public Petbreed getPetbreed() {
		return this.petbreed;
	}

	public void setPetbreed(Petbreed petbreed) {
		this.petbreed = petbreed;
	}
	
	public Pettype getPettype() {
		return this.pettype;
	}

	public void setPettype(Pettype pettype) {
		this.pettype = pettype;
	}
	
	public List<Petdrenching> getPetdrenchings() {
		return this.petdrenchings;
	}

	public void setPetdrenchings(List<Petdrenching> petdrenchings) {
		this.petdrenchings = petdrenchings;
	}
	
	public List<Petvaccine> getPetvaccines() {
		return this.petvaccines;
	}

	public void setPetvaccines(List<Petvaccine> petvaccines) {
		this.petvaccines = petvaccines;
	}
	
}