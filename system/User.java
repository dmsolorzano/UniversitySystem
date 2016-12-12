package system;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;

/** An abstract class which represents types of users
 * @author Darren Solorzano
 * @author Reynaldo Martinez
 * @author Chris Santos
 * @version 1.6
 * */
public class User {
	
	private int id;
	private String name;
	private String username;
	private String password;
	public static Course[] courses; //Array of courses
	private static Admin Senior = new Admin(00001, "Senior Admin", "adminU", "adminP");
	Student s1;

	public User(int id, String name, String user, String pass) {
		this.setId(id);
		this.setName(name);
		this.username = user;
		this.password = pass;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	private void Admin(){}	// Singleton constructor for Admin
	
	public static Admin getInstance(){ //changed to public, don't know if it has to be protected to work
		return Senior;
	}

	/*Modifiers and Accessors for User class*/
	public Course[] returnCourses(){
		return courses;
	}
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
	// Is this for admin only? Student is also able to use it
	public boolean logIn() throws Exception { 
		if (Senior.accessUsername(username) == true){
			if (Senior.accessPassword(password) == true){
				return true;
			} else {
				System.out.println("Incorrect Password. Try Again.");
				return false;
			}
		} else {
			System.out.println("Incorrect Username. Try Again.");
			return false;
		}
	}
	/** Method to add a course to an individual student's Transcript
	 * */
	public void addCourseToTranscript(Course course){
		if(!s1.courses.contains(course)){
			s1.courses.add(course);
			System.out.println("Course added to transcript");
		}
	}
	/**Method to remove a course from an individual's transcript
	 * */
	public void removeCourseFromTranscript(Course course){
		if(s1.courses.contains(course)){
			s1.courses.remove(course);
			System.out.println("Course Successfully removed");
		}
	}
	/** Imports course information into array of objects from the course file
	 * @throws Exception
	 * @see accessDatabase*/
	public static Course[] exportCourses() throws Exception{
		Admin temp = Admin.getInstance();
		courses = new Course[100];
		try {
			temp.accessDatabase(); // create connection
			Statement stmt = temp.accessDatabase().createStatement();
			// if you only need a few columns, specify them by name instead of using "*"
			String query = "SELECT * FROM course";

			stmt.execute("use university;");
			// execute the query, and get a java resultset
			ResultSet rs = stmt.executeQuery(query); //IMPORTANT LINE OF CODE!!!!!

			// iterate through the java resultset
			int i = 0;
			while (rs.next()){//Genius piece of code - this will be extremely handy when we need to import and export information from the database
				int id = rs.getInt("id");
				String name = rs.getString("courseName");
				Date startDate = rs.getDate("startDate");
				Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String date = formatter.format(startDate);
				// print the results
				//System.out.format("%s, %s, %s,\n", id, name, startDate);
				Course course = new Course(name, date, id); // different fields
				courses[i]=course;
				i++;
			}
		} catch (Exception e){}
		return courses;
	}
	
}