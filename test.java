import java.sql.*;
import java.io.IOException;
/** The test class is used to run simulations to ensure the system is working as intended
 * @author Darren Solorzano
 * @author Reynaldo Martinez
 * @author Chris Santos
 * @version 1.4
 * */
public class test{
	public static void main(String[] args) throws Exception{
		User u = new User(90, "name", "name", "name"); //User object
		Admin a = new Admin(0, null, null, null); //Administrator object
		Course c = new Course("CS 3331", "arbitarydate", 101); // Course object
		Object[] courses = null;
		
		a.createDatabase();
		//courses[0]=a.createCourse();

	}
	
}
