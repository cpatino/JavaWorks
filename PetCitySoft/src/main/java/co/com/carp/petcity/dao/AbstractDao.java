package co.com.carp.petcity.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.carp.petcity.util.Configuration;

/**
 * This class is attempt to be an entry point to all DAO classes that must be created.
 * 
 * @author Carlos Rodriguez
 *
 */
public abstract class AbstractDao implements IDao {
	
	/**
	 * {@link DataSource} object
	 */
	private DataSource dataSource;
	
	/**
	 * {@link Object} that will be used to store data.
	 */
	protected Object entity;
	
	public AbstractDao() {
		super();
		dataSource = Configuration.getInstance().getDataSource();
	}

	@Override
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		return template;
	}
	
	public void setEntity(Object entity) {
		this.entity = entity;
	}

}
