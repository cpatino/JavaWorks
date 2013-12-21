package co.com.carp.petcity.entity;

/**
 * This class is attempt to manage application's user
 * 
 * @author Carlos Rodriguez
 *
 */
public class User extends Person {
	
	/**
	 * Application login for user
	 */
	private String login;
	
	/**
	 * Application password for user
	 */
	private String password;
	
	
	public User(int identification,int documentId,String name,String email,String login,String password) {
		super(documentId, documentId, password, password);
		this.login= login;
		this.password= password;
		
	}
	
	@Override
	public boolean equals(Object arg) {
		if (super.equals(arg)) {
			return false;
		}
		if (!this.login.equals(((User)arg).login)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ";User={login:" + this.login + ";" +
				"password:" + this.password +  
				";}";
	}

}
