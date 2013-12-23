package co.com.carp.petcity.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.carp.petcity.dao.mapper.OwnerRowMapper;
import co.com.carp.petcity.entity.Owner;

public class OwnerDao extends AbstractDao {
	
	@Override
	public void create() {
		JdbcTemplate insert = getJdbcTemplate();
		if (entity != null) {
			int documentId = ((Owner)entity).getDocumentId();
			String name = ((Owner)entity).getName();
			String email = ((Owner)entity).getEmail();
			String address = ((Owner)entity).getAddress();
			String cellphone = ((Owner)entity).getCellphone();
			String phone = ((Owner)entity).getPhone();
			insert.update("INSERT INTO owner (documentId, name, email, address, cellphone, phone) VALUES(?,?,?,?,?,?)",
					new Object[] { documentId, name, email, address, cellphone, phone });
		}
	}

	@SuppressWarnings("unchecked")
	public List<Owner> select(int documentId) {
		JdbcTemplate select = getJdbcTemplate();
	    List<Owner> ownerList = select
	        .query("select identification, documentId, name, email, address, cellphone, phone from owner where documentId = ?",
	            new Object[] { documentId },
	            new OwnerRowMapper());	    
	    return ownerList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Owner> selectUsingName(String name) {
		JdbcTemplate select = getJdbcTemplate();
	    return select
	        .query("select identification, documentId, name, email, address, cellphone, phone from owner where name like \'%?%\' ",
	            new Object[] { name },
	            new OwnerRowMapper());
	}

	@SuppressWarnings("unchecked")
	public List<Owner> selectAll() {
		JdbcTemplate select = getJdbcTemplate();
	    return select.query("select identification, documentId, name, email, address, cellphone, phone from owner",
	        new OwnerRowMapper());
	}

	@Override
	public void deleteAll() {
		JdbcTemplate delete = getJdbcTemplate();
	    delete.update("DELETE from owner");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
