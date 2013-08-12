package co.com.carp.petcity.util;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

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
	public Map<String, String> readDatabaseConfiguration() {
		Properties prop = new Properties();
		Map<String, String> configMap = new TreeMap<>();
		try {
			prop.load(Configuration.class
					.getResourceAsStream("/co/com/carp/petcity/configuration/config.properties"));
			configMap.put(JDBC_USER_NAME, prop.getProperty(JDBC_USER_NAME));
			configMap.put(JDBC_PASSWORD, prop.getProperty(JDBC_PASSWORD));
			configMap.put(JDBC_DRIVER, prop.getProperty(JDBC_DRIVER));
			configMap.put(JDBC_HOSTNAME, prop.getProperty(JDBC_HOSTNAME));
			configMap.put(JDBC_PORT, prop.getProperty(JDBC_PORT));
			configMap.put(JDBC_SCHEMA, prop.getProperty(JDBC_SCHEMA));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return configMap;
	}

}
