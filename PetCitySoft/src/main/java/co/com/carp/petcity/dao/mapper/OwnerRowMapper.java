package co.com.carp.petcity.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import co.com.carp.petcity.dao.PetDao;
import co.com.carp.petcity.entity.Owner;
import co.com.carp.petcity.entity.Pet;

public class OwnerRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		OwnerResultSetExtractor extractor = new OwnerResultSetExtractor();
		return extractor.extractData(rs);
	}

}

class OwnerResultSetExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException {
		int identification = rs.getInt(1);
		int documentId = rs.getInt(2);
		String name = rs.getString(3);
		String email = rs.getString(4);
		String address = rs.getString(5);
		String cellphone = rs.getString(6);
		String phone = rs.getString(7);
	    
	    PetDao petDao = new PetDao();
	    Set<Pet> petSet = new HashSet<Pet>(petDao.selectByOwnerId(identification));
	    Owner owner = new Owner(identification, documentId, name, email, address, cellphone, phone);
	    owner.setPetSet(petSet);
		return owner;
	}

}
