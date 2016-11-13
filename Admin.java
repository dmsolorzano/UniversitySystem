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
	
	/**Create Course method - creates a new txt file in the courses folder which will represent a new course
	 * @param name Name of the course to be printed onto the txt file
	 * @param crn2 Course Reference Number(CRN) to be printed into the txt file
	 * */
	public void createCourse() throws Exception{
		Statement stmt = super.accessDatabase().createStatement();
		String courseName = "";
		String courseID = "";
		String sDate = "";
		String eDate = "";
		String sTime = "";
		String eTime = "";
		String days = "";
		
		System.out.print("Enter the name of the course: ");
		courseName = scn.nextLine();
		System.out.print("Enter the course ID: ");
		courseID = scn.nextLine();
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
	}
	
	/**Remove Course method - will search for a line in the Courses.txt file and then remove the line
	 * @param courseToDrop method will search for this string and the crnToDrop parameter together to remove
	 * @param crnToDrop method will search for this string and the courseToDrop parameter together to remove
	 * */
	public void removeCourse() throws Exception{
		Statement stmt = super.accessDatabase().createStatement();
		String courseName = "";
		
		System.out.print("Name of course to be deleted: ");
		courseName = scn.nextLine();
		
		stmt.execute("use university;");
		stmt.execute("delete from courses where Title='"+courseName+"';");
	}
	
	/**Create account method - creates a new txt file based on student or faculty access 
	 * and places into the /Students folder.
	 * @return Returns a reference to an Object file of either:Student, Faculty or Null type
	 * */
	public Object createAccount() throws Exception{	
		Statement stmt = super.accessDatabase().createStatement();
		Student nwStudent = null;
		Faculty nwFaculty = null;
		String ans = "";
		String id = "";
		String fName = "";
		String lName = "";
		
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