import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
		Connection conn = null;
		
		public static Connection ConnDB() {
			
			try {
				
				Class.forName("org.sqlite.JDBC");
				Connection conn = DriverManager.getConnection("jdbc:sqlite:hirenetdb.db");
				return conn;				
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}	
	}
}
