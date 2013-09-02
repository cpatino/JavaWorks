package co.com.carp.petcity.dao;

import java.util.List;
import javax.persistence.Query;
import co.com.carp.petcity.entity.User;

public class UserDAO extends GenericDAO {	

	public User find(int identificacion) {
		return em.find(User.class, identificacion);		
	}	
	
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Query query = em.createNamedQuery("User.findAll");
		return (List<User>) query.getResultList();
	}	

}