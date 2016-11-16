import java.sql.*;
import java.io.IOException;
/** The test class is used to run simulations to ensure the system is working as intended
 * @author Darren Solorzano
 * @author Reynaldo Martinez
 * @author Chris Santos
 * @version 1.4
 * */
public class test extends User{
	
	public test(int id, String name, String user, String pass) {
		super(id, name, user, pass);
		// TODO Auto-generated constructor stub
	}

	
	
	public static void main(String[] args) throws Exception{
		User u = new User(90, "name", "name", "name");
		Admin a = new Admin(0, null, null, null); //Administrator object
		Course c = new Course("CS 3331", "arbitarydate", 101); // Course object
		// We can drop the university table so we don't run into errors
		u.createDatabase();

		//a.createCourse(c.getCourseName(), c.getcRN());
		//a.removeCourse("jpo", 102);
		//a.createAccount();
		
	}
	
}
