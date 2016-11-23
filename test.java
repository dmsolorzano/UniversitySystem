import java.sql.*;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
/** The test class is used to run simulations to ensure the system is working as intended
 * @author Darren Solorzano
 * @author Reynaldo Martinez
 * @author Chris Santos
 * @version 1.4
 * */
public class test{
	static Course[] courses = new Course[100];
	public static void main(String[] args) throws Exception{
		User u = new User(90, "name", "name", "name"); //User object
		Admin a = new Admin(0, null, null, null); //Administrator object
		Course c = new Course("CS 3331", "arbitarydate", 101); // Course object
		Student s = new Student(0, null, null, null);
		
		s.coursesCompleted.put(c, true);
		a.createDatabase();
		importCourses();
		for(int i =0;i<5; i++){
			System.out.println(courses[i].getCourseName());
		}
	}
	
	/** Imports course information into array of objects from the course file
	 * @throws Exception
	 * @see accessDatabase*/
	public static boolean importCourses() throws Exception{
		User user = new User(0, null, null, null);
		boolean test = false;
		try {
			user.accessDatabase();
			Statement stmt = user.accessDatabase().createStatement();
			// if you only need a few columns, specify them by name instead of using "*"
			String query = "SELECT * FROM course";

			stmt.execute("use university;");
			// execute the query, and get a java resultset
			ResultSet rs = stmt.executeQuery(query); //IMPORTANT LINE OF CODE!!!!!

			// iterate through the java resultset
			int i =0;
			while (rs.next()){//Genius piece of code - this will be extremely handy when we need to import and export information from the database
				int id = rs.getInt("id");
				String name = rs.getString("courseName");
				Date startDate = rs.getDate("startDate");
				Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String date = formatter.format(startDate);
				// print the results
				//System.out.format("%s, %s, %s,\n", id, name, startDate);
				Course course = new Course(name, date, id);
				courses[i]=course;
				i++;
			}
			test = true;
		} catch (Exception e){
			return test;
		}
		return test;
	}
}
