import java.io.IOException;
/** The test class is used to run simulations to ensure the system is working as intended
 * @author Darren Solorzano
 * @author Reynaldo Martinez
 * @author Chris Santos
 * @version 1.3
 * */
public class test {
	public static void main(String[] args) throws IOException{
		Admin a = new Admin(0, null, null, null); //Administrator object
		Course c = new Course("CS 3331", "arbitarydate", 101); // Course object
		//a.createCourse(c.getCourseName(), c.getcRN());
		//a.removeCourse("jpo", 102);
		a.createAccount();
		
	}
	
}
