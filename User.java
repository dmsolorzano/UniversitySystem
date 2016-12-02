import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;

/** An abstract class which represents types of users
 * @author Darren Solorzano
 * @author Reynaldo Martinez
 * @author Chris Santos
 * @version 1.5
 * */
public class User {
	
	private int id;
	private String name;
	private String username;
	private String password;
	private static Course[] courses;

	public User(int id, String name, String user, String pass) {
		this.setId(id);
		this.setName(name);
		this.username = user;
		this.password = pass;
	}

	/*Modifiers and Accessors for User class*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/** Imports course information into array of objects from the course file
	 * @throws Exception
	 * @see accessDatabase*/
	public static boolean importCourses() throws Exception{
		Admin temp = new Admin(0011, "john", "admin", "admin");
		courses = new Course[100];
		boolean test = false;
		try {
			temp.accessDatabase();
			Statement stmt = temp.accessDatabase().createStatement();
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