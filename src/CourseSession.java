import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CourseSession {
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;

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
		int numberOfDays = 16 * 7 - 3;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		Date endDate = calendar.getTime();
		return endDate;
	}

	Date getStartDate() {
		return startDate;
	}
	
}
