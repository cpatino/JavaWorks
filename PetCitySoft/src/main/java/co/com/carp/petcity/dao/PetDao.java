package co.com.carp.petcity.dao;

import java.awt.Image;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.carp.petcity.dao.mapper.PetRowMapper;
import co.com.carp.petcity.entity.Owner;
import co.com.carp.petcity.entity.Pet;

public class PetDao extends AbstractDao {
	
	@Override
	public void create() {
		JdbcTemplate insert = getJdbcTemplate();
		if (entity != null) {
			String name = ((Pet)entity).getName();
			String color = ((Pet)entity).getColor();
			String sex = ((Pet)entity).getSex();
			Date bornDate = ((Pet)entity).getBornDate();
			String bornPlace = ((Pet)entity).getBornPlace();
			String reproduction = ((Pet)entity).getReproduction();
			Image photo = ((Pet)entity).getPhoto();
			int idPetBreed = ((Pet)entity).getBreed().getIdentification();
			int idOwner = ((Pet)entity).getIdOwner();
			insert.update("INSERT INTO pet (name, color, sex, bornDate, bornPlace, reproductionState, photo, idPetBreed, idOwner) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)",
					new Object[] { name, color, sex, bornDate, bornPlace, reproduction, photo, idPetBreed, idOwner  });
		}
	}

	@SuppressWarnings("unchecked")
	public List<Pet> select(int identification) {
		JdbcTemplate select = getJdbcTemplate();
	    return select
	        .query("select identification, name, color, sex, bornDate, bornPlace, reproductionState, photo, idPetBreed, idOwner from pet where identification = ?",
	            new Object[] { identification },
	            new PetRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<Pet> selectByOwnerId(int idOwner) {
		JdbcTemplate select = getJdbcTemplate();
	    return select
	        .query("select identification, name, color, sex, bornDate, bornPlace, reproductionState, photo, idPetBreed, idOwner from pet where idOwner = ?",
	            new Object[] { idOwner },
	            new PetRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<Owner> selectUsingName(String name) {
		JdbcTemplate select = getJdbcTemplate();
	    return select
	        .query("select identification, name, color, sex, bornDate, bornPlace, reproductionState, photo, idPetBreed, idOwner from pet where name like \'%?%\' ",
	            new Object[] { name },
	            new PetRowMapper());
	}

	@SuppressWarnings("unchecked")
	public List<Pet> selectAll() {
		JdbcTemplate select = getJdbcTemplate();
	    return select.query("select identification, name, color, sex, bornDate, bornPlace, reproductionState, photo, idPetBreed, idOwner from pet",
	        new PetRowMapper());
	}

	@Override
	public void deleteAll() {
		JdbcTemplate delete = getJdbcTemplate();
	    delete.update("DELETE from pet");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
