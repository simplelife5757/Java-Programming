//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
import java.util.*; //��Ű�� ����Ʈ

public class CourseSession {
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;
	final int daysFromFridayToMonday = 3;
	final int daysInWeek = 7;
	final int seessionLength = 16;
	int numberOfDays = seessionLength * daysInWeek - daysFromFridayToMonday;

	public CourseSession(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
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

	void enroll(Student student) {
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
	
}
