package co.com.carp.petcity.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Query;

import co.com.carp.petcity.entity.Owner;

public class OwnerDAO extends GenericDAO {

	@SuppressWarnings("unchecked")
	public Set<Owner> findOwnerForFilter(String filter) {
		Set<Owner> ownerList = new TreeSet<Owner>();
		String strSql = "SELECT o FROM Owner o";		
		
		if (!filter.isEmpty()) {
			strSql += " where o.documentId like '%:filter%'  or lower(o.name) like '%:filter%'";
		}

		Query query = em.createQuery(strSql);
		if (!filter.isEmpty()) {
			query.setParameter("filter", filter.toLowerCase());
		}
		
		List<co.com.carp.petcity.jpa.entity.Owner> ownerJpaList = (List<co.com.carp.petcity.jpa.entity.Owner>) query.getResultList();
		for (co.com.carp.petcity.jpa.entity.Owner ownerJpa:ownerJpaList){
			Owner owner = new Owner();
			owner.setIdentification(ownerJpa.getDocumentId());
			owner.setName(ownerJpa.getName());
			owner.setPhone(ownerJpa.getPhone());
			owner.setCellphone(ownerJpa.getCellphone());
			owner.setAddress(ownerJpa.getAddress());
			owner.setEmail(ownerJpa.getEmail());
			
			
			ownerList.add(owner);
			 
		}
		
		return ownerList;
	}

}
