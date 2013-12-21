package co.com.carp.petcity.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		UserResultSetExtractor extractor = new UserResultSetExtractor();
		return extractor.extractData(rs);
	}

}
