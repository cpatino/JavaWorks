package co.com.carp.petcity.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.carp.petcity.dao.mapper.UserRowMapper;
import co.com.carp.petcity.entity.User;

public class UserDao implements IUserDao {

	private DataSource dataSource;
	
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}

	@Override
	public void create(int documentId, String name, String email, String login,
			String password) {
		JdbcTemplate insert = new JdbcTemplate(dataSource);
	    insert.update("INSERT INTO user (documentId, name, email, login, password) VALUES(?,?,?,?,?)",
	        new Object[] { documentId, name, email, login, password });
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> select(int documentId) {
		JdbcTemplate select = new JdbcTemplate(dataSource);
	    return select
	        .query("select identification, documentId, name, email, login, password from user where documentId = ?",
	            new Object[] { documentId },
	            new UserRowMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAll() {
		JdbcTemplate select = new JdbcTemplate(dataSource);
	    return select.query("select identification, documentId, name, email, login, password from user",
	        new UserRowMapper());
	}

	@Override
	public void deleteAll() {
		JdbcTemplate delete = new JdbcTemplate(dataSource);
	    delete.update("DELETE from user");
	}

	@Override
	public void delete(int documentId) {
		JdbcTemplate delete = new JdbcTemplate(dataSource);
	    delete.update("DELETE from user where documentId = ?",
	        new Object[] { documentId });
	}

}
