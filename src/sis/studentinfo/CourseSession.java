package sis.studentinfo;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
import java.util.*; //��Ű�� ����Ʈ

public class CourseSession {
	private static int count;
	static final String NEWLINE = System.getProperty("line.separator");
	static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "-" + NEWLINE;
	static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";
	private String department;
	private String number;
	private Date startDate;
	private ArrayList<Student> students = new ArrayList<Student>();
	final int daysFromFridayToMonday = 3;
	final int daysInWeek = 7;
	final int seessionLength = 16;
	int numberOfDays = seessionLength * daysInWeek - daysFromFridayToMonday;
	private int numberOfCredits;

	private CourseSession(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}
	//private�� �����Ͽ� �ٸ� Ŭ�������� ī���͸� �ø��� ���� ���´�. 
	private static void incremetCount() {
		++count;
	}
	//factory method 
	public static CourseSession create(String department, String number, Date startDate) {
		incremetCount();
		return new CourseSession(department, number, startDate);
	}
	
	static void resetCount() {
		count = 0;
	}
	String getDepartment() {
		return department;
	}

	String getNumber() {
		return number;
	}
	// Student Ŭ������ CourseSession Ŭ���� ��� �ٸ� ��ü���� �����͸� �������� �޼ҵ带 �����Ѵ�. �̰� ��ü ������ �ƴϰ�
	// � ���� �ϵ��� �ϱ� ���� �޼����� ������ �����ؾ� �Ѵ�.

	int getNumberOfStudents() {
		return students.size();
	}

	public void enroll(Student student) {
		student.addCredits(numberOfCredits);
		students.add(student);
	}
	
	Student get(int index) {
		return students.get(index);
	}

	Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}

	Date getStartDate() {
		return startDate;
	}

	public ArrayList<Student> getAllStudents(){
		return students;
	}

	static int getCount() {
		return count;
	}
	void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	
	
}
