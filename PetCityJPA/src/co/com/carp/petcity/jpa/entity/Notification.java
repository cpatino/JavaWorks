package co.com.carp.petcity.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the notification database table.
 * 
 */
@Entity
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identification;

    @Temporal( TemporalType.TIMESTAMP)
	private Date creationDate;

	private byte level;

	private String message;

    @Temporal( TemporalType.TIMESTAMP)
	private Date notificationDate;

	private byte sendEmail;

	//bi-directional many-to-one association to Pet
    @ManyToOne
	@JoinColumn(name="idPet")
	private Pet pet;

    public Notification() {
    }

	public int getIdentification() {
		return this.identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public byte getLevel() {
		return this.level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getNotificationDate() {
		return this.notificationDate;
	}

	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}

	public byte getSendEmail() {
		return this.sendEmail;
	}

	public void setSendEmail(byte sendEmail) {
		this.sendEmail = sendEmail;
	}

	public Pet getPet() {
		return this.pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
}