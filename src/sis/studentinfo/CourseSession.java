package sis.studentinfo;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
import java.util.*; //패키지 임포트

public class CourseSession extends Session {
	static final String NEWLINE = System.getProperty("line.separator");
	static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "-" + NEWLINE;
	static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";
	private static int count;
	
	protected int getSessionLength() {
		return 16;
	}
	
	//private로 선언하여 다른 클래스에서 카운터를 올리는 것을 막는다. 
	private static void incremetCount() {
		++count;
	}
	//factory method 
	public static CourseSession create(String department, String number, Date startDate) {
		return new CourseSession(department, number, startDate);
	}
	
	protected CourseSession (String department, String number, Date startDate) {
		super(department, number, startDate);
		CourseSession.incremetCount();
	}
	
	static void resetCount() {
		count = 0;
	}
	
	static int getCount() {
		return count;
	}
	
	
	
}
