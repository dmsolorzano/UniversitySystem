import java.util.Scanner;
import java.sql.*;

/** The administrator class which represents users with administrative access
 * @author Darren Solorzano
 * @author Reynaldo Martinez
 * @author Chris Santos
 * @version 1.4
 * */
public class Admin extends User{
	static Scanner scn = new Scanner(System.in);
	
	public Admin(int id, String name, String user, String pass) {
		super(id, name, user, pass);
	}
	
	/** Checks is student has completed all courses required to graduate
	 * @returns true if student is ready to graduate, false otherwise
	 * */
	public boolean checkGraduation(Student student){
		if(student.coursesCompleted.containsValue(false))
				return false;
		return true;
	}
	
	/**Create Course method - creates a new Course object instance and stores the information into the database
	 * @return returns a Course Object file that has been created
	 * */
	public Object createCourse(Student s) throws Exception{
		Statement stmt = super.accessDatabase().createStatement();
		Course course = null;
		int courseID = 0;
		String courseName, sDate, eDate, sTime, eTime, days= "";
		
		System.out.print("Enter the name of the course: ");
		courseName = scn.nextLine();
		System.out.print("Enter the course ID: ");
		courseID = scn.nextInt();
		System.out.print("Enter the start date(yyyymmdd): ");
		sDate = scn.nextLine();
		System.out.print("Enter the end date(yyyymmdd): ");
		eDate = scn.nextLine();
		System.out.print("Enter the start time: ");
		sTime = scn.nextLine();
		System.out.print("Enter the end time: ");
		eTime = scn.nextLine();
		System.out.print("Enter what days the class will meet: ");
		days = scn.nextLine();
		
		stmt.execute("use university;");
		stmt.execute("insert into courses values ('"+courseID+"', "+courseName+", "+sTime+
				", "+eTime+", '"+days+"', '"+sDate+"', '"+eDate+"');");
		course = new Course(courseName, sDate, courseID); //Set course value
		s.coursesCompleted.put(course, false); //Add course to list of uncompleted course;
		return course;
	}
	
	/**Remove Course method - will search for a course with the name to be deleted and remove it
	 * */
	public boolean removeCourse(Course c, Student s) throws Exception{
		Statement stmt = super.accessDatabase().createStatement();
		boolean test = false;
		
		try {
			try {
				if(s.coursesCompleted.containsKey(c)){
					s.coursesCompleted.remove(c);
					System.out.println("Course has been completed");
				}
			} catch (Exception e){
			}
			stmt.execute("use university;");
			stmt.execute("delete from courses where Title='"+c.courseName+"';");
			test = true;
		} catch (Exception e){
			return test;
		}
		return test;
	}
	
	/**Create account method - creates a new Account Object instance and stores the information into the database
	 * @return Returns a reference to an Object file of either:Student, Faculty or Null type
	 * @see accessDatabase()
	 * */
	public Object createAccount() throws Exception{	//We could maybe separate this into two methods(createStudent(), createFaculty())
		Statement stmt = super.accessDatabase().createStatement();
		Student nwStudent = null;
		Faculty nwFaculty = null;
		String ans, id, fName, lName = "";
		
		System.out.print("Are you a Student or Faculty? ");
		ans = scn.nextLine();
		System.out.print("UTEP ID: ");
		id = scn.nextLine();
		System.out.print("First Name: ");
		fName = scn.nextLine();
		if (ans.toLowerCase().equals("student")){
			System.out.print("Last Name: ");
			lName = scn.nextLine();
			stmt.execute("use university");
			stmt.execute("insert into student values ("+id+", '"+fName+"', '"+lName+"');");
			nwStudent = new Student(Integer.valueOf(id), fName+" "+lName, "", "");
			return nwStudent;
		}
		if (ans.toLowerCase().equals("faculty")){
			System.out.print("Last Name: ");
			lName = scn.nextLine();
			stmt.execute("use university");
			stmt.execute("insert into faculty values ("+id+", '"+fName+"', '"+lName+"');");
			nwFaculty = new Faculty(Integer.valueOf(id), fName+" "+lName, "", "");
			return nwFaculty;
		}
		return null; 
	}
}