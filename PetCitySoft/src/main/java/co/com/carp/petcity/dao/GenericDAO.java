package co.com.carp.petcity.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class GenericDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PetCityPU");

	@PersistenceContext
	protected EntityManager em = factory.createEntityManager();

	public Object find(int identificacion) {
		return null;
	}	
	
	public void create(Object obj) {
		em.persist(obj);		
	}
	
	public void update(Object obj) {
		em.merge(obj);		
	}

	public void delete(Object obj) {
		em.remove(obj);		
	}
	

}
