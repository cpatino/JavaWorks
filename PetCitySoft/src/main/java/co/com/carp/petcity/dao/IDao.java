package co.com.carp.petcity.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public interface IDao {
	
	JdbcTemplate getJdbcTemplate();
	
	void create();
	
	void update();
	
	void deleteAll();

}
