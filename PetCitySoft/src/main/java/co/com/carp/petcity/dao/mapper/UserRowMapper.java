package co.com.carp.petcity.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import co.com.carp.petcity.entity.User;

public class UserRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		UserResultSetExtractor extractor = new UserResultSetExtractor();
		return extractor.extractData(rs);
	}

}

class UserResultSetExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException {
		int identification = rs.getInt(1);
		int documentId = rs.getInt(2);
		String name = rs.getString(3);
		String email = rs.getString(4);
		String login = rs.getString(5);
		String password = rs.getString(6);
		User user = new User(identification, documentId, name, email, login, password);
		return user;
	}

}
