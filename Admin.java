import java.util.Scanner;
import java.sql.*;

/** The administrator class which represents users with administrative access
 * @author Darren Solorzano
 * @author Reynaldo Martinez
 * @author Chris Santos
 * @version 1.3
 * */
public class Admin extends User{

	static Scanner scn = new Scanner(System.in);
	
	public Admin(int id, String name, String user, String pass) {
		super(id, name, user, pass);
	}
	
	/**Method to return the course catalog
	 * */
	public void showCourseCatalog(){
		
	}
	/**Create Course method - creates a new Course object instance and stores the information into the database
	 * */
	public Object createCourse() throws Exception{
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
		stmt.execute("insert into courses values ('"+courseName+"', "+courseID+", "+sDate+
				", "+eDate+", '"+sTime+"', '"+eTime+"', '"+days+"');");
		return course= new Course(courseName, sDate, courseID); //Here
	}
	
	/**Remove Course method - will search for a course with the name to be deleted and remove it
	 * */
	public void removeCourse() throws Exception{
		Statement stmt = super.accessDatabase().createStatement();
		String courseName = "";
		
		System.out.print("Name of course to be deleted: ");
		courseName = scn.nextLine();
		
		stmt.execute("use university;");
		stmt.execute("delete from courses where Title='"+courseName+"';");
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