package co.com.carp.petcity.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identification;

	private int documentId;

	private String email;

	private String login;

	private String name;

	private String password;

	//bi-directional many-to-one association to Clinichistory
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Clinichistory> clinichistories;

    public User() {
    }

	public int getIdentification() {
		return this.identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
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

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Clinichistory> getClinichistories() {
		return this.clinichistories;
	}

	public void setClinichistories(List<Clinichistory> clinichistories) {
		this.clinichistories = clinichistories;
	}
	
}