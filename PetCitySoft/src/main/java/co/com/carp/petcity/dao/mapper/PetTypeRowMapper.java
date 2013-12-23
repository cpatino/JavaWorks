package co.com.carp.petcity.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import co.com.carp.petcity.entity.PetType;

public class PetTypeRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		PetTypeResultSetExtractor extractor = new PetTypeResultSetExtractor();
		return extractor.extractData(rs);
	}

}

class PetTypeResultSetExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException {
		int identification = rs.getInt(1);
		String name = rs.getString(2);
		String typeClass = rs.getString(3);
		return new PetType(identification, name, typeClass);
	}

}
