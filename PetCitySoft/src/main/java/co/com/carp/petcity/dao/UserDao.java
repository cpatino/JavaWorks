package co.com.carp.petcity.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.carp.petcity.dao.mapper.UserRowMapper;
import co.com.carp.petcity.entity.User;

public class UserDao extends AbstractDao {
	
	@Override
	public void create() {
		JdbcTemplate insert = getJdbcTemplate();
		if (entity != null) {
			int documentId = ((User)entity).getDocumentId();
			String name = ((User)entity).getName();
			String email = ((User)entity).getEmail();
			String login = ((User)entity).getLogin();
			String password = ((User)entity).getPassword();
			insert.update("INSERT INTO user (documentId, name, email, login, password) VALUES(?,?,?,?,?)",
					new Object[] { documentId, name, email, login, password });
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> select(int documentId) {
		JdbcTemplate select = getJdbcTemplate();
	    return select
	        .query("select identification, documentId, name, email, login, password from user where documentId = ?",
	            new Object[] { documentId },
	            new UserRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<User> selectUsingLogin(String login, String password) {
		JdbcTemplate select = getJdbcTemplate();
	    return select
	        .query("select identification, documentId, name, email, login, password from user where login = ? AND password = ? ",
	            new Object[] { login, password },
	            new UserRowMapper());
	}

	@SuppressWarnings("unchecked")
	public List<User> selectAll() {
		JdbcTemplate select = getJdbcTemplate();
	    return select.query("select identification, documentId, name, email, login, password from user",
	        new UserRowMapper());
	}

	@Override
	public void deleteAll() {
		JdbcTemplate delete = getJdbcTemplate();
	    delete.update("DELETE from user");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
