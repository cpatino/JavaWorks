package co.com.carp.petcity.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.carp.petcity.dao.mapper.PetBreedRowMapper;
import co.com.carp.petcity.entity.PetBreed;

public class PetBreedDao extends AbstractDao {
	
	@Override
	public void create() {
		JdbcTemplate insert = getJdbcTemplate();
		if (entity != null) {
			String name = ((PetBreed)entity).getName();
			int idPetType = ((PetBreed)entity).getPetType().getIdentification();
			insert.update("INSERT INTO petbreed (name, idPetType) VALUES(?,?,?)",
					new Object[] { name, idPetType });
		}
	}

	@SuppressWarnings("unchecked")
	public List<PetBreed> select(int identification) {
		JdbcTemplate select = getJdbcTemplate();
	    return select
	        .query("select identification, name, idPetType from petbreed where identification = ?",
	            new Object[] { identification },
	            new PetBreedRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<PetBreed> selectUsingName(String name) {
		JdbcTemplate select = getJdbcTemplate();
	    return select
	        .query("select identification, name, idPetType from petbreed where name = ? ",
	            new Object[] { name },
	            new PetBreedRowMapper());
	}

	@SuppressWarnings("unchecked")
	public List<PetBreed> selectAll() {
		JdbcTemplate select = getJdbcTemplate();
	    return select.query("select identification, name, idPetType from petbreed",
	        new PetBreedRowMapper());
	}

	@Override
	public void deleteAll() {
		JdbcTemplate delete = getJdbcTemplate();
	    delete.update("DELETE from petbreed");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
