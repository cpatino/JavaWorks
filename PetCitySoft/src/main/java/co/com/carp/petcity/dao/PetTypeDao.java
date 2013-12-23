package co.com.carp.petcity.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.carp.petcity.dao.mapper.PetTypeRowMapper;
import co.com.carp.petcity.entity.PetType;

public class PetTypeDao extends AbstractDao {
	
	@Override
	public void create() {
		JdbcTemplate insert = getJdbcTemplate();
		if (entity != null) {
			String name = ((PetType)entity).getName();
			String typeClass = ((PetType)entity).getTypeClass();
			insert.update("INSERT INTO pettype (name, class) VALUES(?,?,?)",
					new Object[] { name, typeClass });
		}
	}

	@SuppressWarnings("unchecked")
	public List<PetType> select(int identification) {
		JdbcTemplate select = getJdbcTemplate();
	    return select
	        .query("select identification, name, class from pettype where identification = ?",
	            new Object[] { identification },
	            new PetTypeRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<PetType> selectUsingName(String name) {
		JdbcTemplate select = getJdbcTemplate();
	    return select
	        .query("select identification, name, class from pettype where name = ? ",
	            new Object[] { name },
	            new PetTypeRowMapper());
	}

	@SuppressWarnings("unchecked")
	public List<PetType> selectAll() {
		JdbcTemplate select = getJdbcTemplate();
	    return select.query("select identification, name, class from pettype",
	        new PetTypeRowMapper());
	}

	@Override
	public void deleteAll() {
		JdbcTemplate delete = getJdbcTemplate();
	    delete.update("DELETE from pettype");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
