package co.com.carp.petcity.util;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import javax.swing.JComboBox;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * This class is attempt to control all necessary configuration that will be
 * load from config.property file. All static finals variables must exists on
 * file.
 * 
 * @author Carlos Rodriguez
 * 
 */
public class Configuration {
	
	/**
	 * This message is used around the entire application, the most of times when 
	 * a {@link JComboBox} value needs to be selected. 
	 */
	public static String SELECT_ONE_MSG = "Seleccione uno...";

	/**
	 * Own object that doesn't allow create another instance from itself.
	 */
	private static Configuration configuration = new Configuration();

	/**
	 * Configuration that stores user name to login in database.
	 */
	public static final String JDBC_USER_NAME = "jdbc.username";

	/**
	 * Configuration that stores user's password from database.
	 */
	public static final String JDBC_PASSWORD = "jdbc.password";

	/**
	 * Configuration that stores driver to be used to login on database.
	 */
	public static final String JDBC_DRIVER = "jdbc.driver";

	/**
	 * Configuration that stores host name where is located database.
	 */
	public static final String JDBC_HOSTNAME = "jdbc.hostname";

	/**
	 * Configuration that stores database port.
	 */
	public static final String JDBC_PORT = "jdbc.port";

	/**
	 * Configuration that stores database name.
	 */
	public static final String JDBC_SCHEMA = "jdbc.schema";
	
	/**
	 * Configuration that stores JDBC URL.
	 */
	public static final String JDBC_URL = "jdbc.url";
	
	/**
	 * {@link Map} object with database configuration 
	 */
	private Map<String, String> configMap;
	
	/**
	 * {@link DriverManagerDataSource} that will be used to get access to database. 
	 */
	private DriverManagerDataSource dataSource;

	/**
	 * Private constructor in order to implement singleton.
	 */
	private Configuration() {
		super();
	}

	/**
	 * It allows get a object copy from {@link Configuration}. 
	 * 
	 * @return {@link Configuration} object.
	 */
	public static Configuration getInstance() {
		return configuration;
	}

	/**
	 * It reads all database configurations located on config.property file
	 * 
	 * @return {@link Map} with all configuration loaded from file.
	 */
	private void readDatabaseConfiguration() {
		Properties prop = new Properties();
		configMap = new TreeMap<>();
		try {
			prop.load(Configuration.class
					.getResourceAsStream("/co/com/carp/petcity/configuration/database.properties"));
			configMap.put(JDBC_USER_NAME, prop.getProperty(JDBC_USER_NAME));
			configMap.put(JDBC_PASSWORD, prop.getProperty(JDBC_PASSWORD));
			configMap.put(JDBC_DRIVER, prop.getProperty(JDBC_DRIVER));
			configMap.put(JDBC_HOSTNAME, prop.getProperty(JDBC_HOSTNAME));
			configMap.put(JDBC_PORT, prop.getProperty(JDBC_PORT));
			configMap.put(JDBC_SCHEMA, prop.getProperty(JDBC_SCHEMA));
			String url = prop.getProperty(JDBC_URL);
			url = url.replace("#" + JDBC_HOSTNAME + "#", configMap.get(JDBC_HOSTNAME));
			url = url.replace("#" + JDBC_PORT + "#", configMap.get(JDBC_PORT));
			url = url.replace("#" + JDBC_SCHEMA + "#", configMap.get(JDBC_SCHEMA));
			configMap.put(JDBC_URL, url);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * It gets {@link DriverManagerDataSource} object.
	 * 
	 * @return
	 */
	public DriverManagerDataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new DriverManagerDataSource();
			if (configMap == null) {
				this.readDatabaseConfiguration();
			}
		    dataSource.setDriverClassName(configMap.get(JDBC_DRIVER));
		    dataSource.setUrl(configMap.get(JDBC_URL));
		    dataSource.setUsername(configMap.get(JDBC_USER_NAME));
		    dataSource.setPassword(configMap.get(JDBC_PASSWORD));
		}
		return dataSource;
	}

}
