package system;

import java.io.*;

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
	 * @param date holds the date which class is held
	 * @param cRN holds the course reference number(CRN)
	 * */
	public Course(String courseName, String date, int cRN) {
		super();
		this.courseName = courseName;
		this.date = date;
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
