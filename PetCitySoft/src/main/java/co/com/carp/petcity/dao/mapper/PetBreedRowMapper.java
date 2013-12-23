package co.com.carp.petcity.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import co.com.carp.petcity.dao.PetTypeDao;
import co.com.carp.petcity.entity.PetBreed;
import co.com.carp.petcity.entity.PetType;

public class PetBreedRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		PetBreedResultSetExtractor extractor = new PetBreedResultSetExtractor();
		return extractor.extractData(rs);
	}

}

class PetBreedResultSetExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException {
		int identification = rs.getInt(1);
		String name = rs.getString(2);
		int idPetType = rs.getInt(3);
		PetTypeDao petTypeDao = new PetTypeDao();
		List<PetType> petTypeList = petTypeDao.select(idPetType);
		return (petTypeList != null && petTypeList.size() == 1) ?
				new PetBreed(identification, name, petTypeList.get(0)) : null;
	}

}
