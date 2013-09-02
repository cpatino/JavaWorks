package co.com.carp.petcity.dao;

import java.util.List;

import javax.persistence.Query;

import co.com.carp.petcity.entity.Pet;

public class PetDAO extends GenericDAO{
	
	public Pet find(int identificacion) {
		return em.find(Pet.class, identificacion);		
	}	
	
	@SuppressWarnings("unchecked")
	public List<Pet> findAll() {
		Query query = em.createNamedQuery("Pet.findAll");
		return (List<Pet>) query.getResultList();
	}	


}
