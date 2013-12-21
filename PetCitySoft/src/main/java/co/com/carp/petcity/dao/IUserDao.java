package co.com.carp.petcity.dao;

import java.util.List;

import javax.sql.DataSource;

import co.com.carp.petcity.entity.User;

public interface IUserDao {
	
	void setDataSource(DataSource ds);
	
	void create(int documentId, String name, String email, String login, String password);
	
	List<User> select(int documentId);
	
	List<User> selectAll();
	
	void deleteAll();
	
	void delete(int documentId);

}
