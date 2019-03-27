package sis.studentinfo;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
import java.util.*; //��Ű�� ����Ʈ

public class CourseSession extends Session {
	static final String NEWLINE = System.getProperty("line.separator");
	static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "-" + NEWLINE;
	static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";
	private static int count;
	
	protected int getSessionLength() {
		return 16;
	}
	
	//private�� �����Ͽ� �ٸ� Ŭ�������� ī���͸� �ø��� ���� ���´�. 
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
