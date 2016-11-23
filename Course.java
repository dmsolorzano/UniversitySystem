import java.io.*;
import java.sql.Date;
import java.util.*;
/** The course class which represents types of courses and their relative fields
 * @author Darren Solorzano
 * @author Reynaldo Martinez
 * @author Chris Santos
 * @version 1.3
 * */
public class Course {

	String courseName;
	String date;
	String time;
	int cRN;

	/** Course constructor
	 * @param courseName holds the name of the course
	 * @param startDate holds the date which class is held
	 * @param cRN holds the course reference number(CRN)
	 * */
	public Course(String courseName, String startDate, int cRN) {//We need to fix these course parameters
		this.courseName = courseName;
		this.date = startDate;
		this.cRN = cRN;
	}

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getcRN() {
		return cRN;
	}
	public void setcRN(int cRN) {
		this.cRN = cRN;
	}
}
