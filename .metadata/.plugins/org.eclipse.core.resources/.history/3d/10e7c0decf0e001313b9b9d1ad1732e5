package co.com.carp.petcity.entity;

/**
 * This class is attempt to manage persons like an abstract concept. 
 * 
 * @author Carlos Rodriguez
 * */
public abstract class Person {
	
	/**
	 * identification from database
	 */
	private int identification;
	
	/**
	 * Document identification
	 */
	private int documentId;
	
	/**
	 * Person's name
	 */
	private String name;
	
	/**
	 * Person's email
	 */
	private String email;

	/**
	 * @return the identification
	 */
	public int getIdentification() {
		return identification;
	}

	/**
	 * @param identification the identification to set
	 */
	public void setIdentification(int identification) {
		this.identification = identification;
	}

	/**
	 * @return the documentId
	 */
	public int getDocumentId() {
		return documentId;
	}

	/**
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object arg) {
		if (arg == null || !(arg instanceof Person)) {
			return false;
		}
		if (this.documentId != ((Person)arg).documentId ||
				!this.name.equals(((Person)arg).name)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hashCode = 85;
		hashCode = hashCode * this.documentId + this.name.hashCode();
		return hashCode;
	}
	
	@Override
	public String toString() {
		return "Person={identification:" + this.identification + ";" +
				"documentId:" + this.documentId + ";" +
				"name:" + this.name + ";" + 
				"email:" + this.email + ";}";
	}
}
