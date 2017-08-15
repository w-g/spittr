package spittr.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC Utilities Class
 * @author V4TOR
 *
 */
public class JDBCUtils {

	private static Properties systemProperties;
	
	/**
	 * ¾²Ì¬´úÂë¿é
	 */
	static {

		systemProperties = new Properties();

		try {

			systemProperties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("application.properties"));

			// load jdbc driver
			Class.forName(systemProperties.getProperty("jdbc.driverClassName"));

		} catch (Exception exception) {
			handleException(exception);
			throw new RuntimeException("JDBCUtil initial error");
		}
	}
	
	private static Connection getConnection() throws SQLException {

		Connection connection = DriverManager.getConnection(systemProperties.getProperty("jdbc.url"), 
				systemProperties.getProperty("jdbc.username"), systemProperties.getProperty("jdbc.password"));
		
		return connection;
	}

	/**
	 * transaction based
	 * @param sqls
	 * @return
	 */
	public static int executeNonQuery(String...sqls) {

		int rowCount = 0;
		Connection connection = null;
		Statement statement = null;

		try {
			connection = getConnection();
			connection.setAutoCommit(false);

			statement = connection.createStatement();
			
			for(String sql : sqls){
				rowCount += statement.executeUpdate(sql);
			}
			
			connection.commit();
		} catch (Exception sqlException) {
			rollbackTransaction(connection);
			handleException(sqlException);
		} finally {
			close(connection);
			close(statement);
		}

		return rowCount;
	}
	
	private static void rollbackTransaction(Connection connection) {
		try {
			connection.rollback();	
		}catch(SQLException sqlException) {
			handleException(sqlException);
		}
	}
	
	private static void close(AutoCloseable closeableObj) {
		if (closeableObj != null) {
			try {
				closeableObj.close();
			} catch (Exception exception) {
				handleException(exception);
			}
		}
	}

	private static void handleException(Exception exception) {
		exception.printStackTrace();
	}
}
