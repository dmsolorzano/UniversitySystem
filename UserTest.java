import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

public class UserTest {
	
	@Test
	public void CreateDatabase_Test() throws Exception {
		/** Object of User created to test the createDatabase method **/
		//User u = new User(90, "name", "name", "name");
		
		/** Should return true if the database was created. **/
		//assertTrue(u.createDatabase());
	}

	@Test
	public void Connection_Test() throws Exception {
		/** Object of Connection created to test the connection method **/
		Connection con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306","root","root_3478");
		
		/* The method should return true due to the fact 
		 * that if the method does get the auto commit status
		 * from the database, this the connection is good.
		 */
		assertTrue(con.getAutoCommit());
		
		/* Method will return false if connection was not made.
		 * Opposite of assertTrue(...)
		 */
		assertFalse(con.getAutoCommit());
	}
}
