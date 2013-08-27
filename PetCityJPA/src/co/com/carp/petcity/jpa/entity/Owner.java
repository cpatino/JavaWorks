package co.com.carp.petcity.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the owner database table.
 * 
 */
@Entity
public class Owner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identification;

	private String address;

	private String cellphone;

	private int documentId;

	private String email;

	private String name;

	private String phone;

    public Owner() {
    }

	public int getIdentification() {
		return this.identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public int getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}